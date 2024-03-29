TARGETS = console-setup mountkernfs.sh ufw resolvconf apparmor x11-common hostname.sh plymouth-log screen-cleanup udev keyboard-setup networking urandom hwclock.sh mountdevsubfs.sh checkroot.sh mountall-bootclean.sh mountall.sh bootmisc.sh mountnfs-bootclean.sh mountnfs.sh kmod checkroot-bootclean.sh checkfs.sh procps
INTERACTIVE = console-setup udev keyboard-setup checkroot.sh checkfs.sh
udev: mountkernfs.sh
keyboard-setup: mountkernfs.sh udev
networking: mountkernfs.sh urandom resolvconf procps
urandom: hwclock.sh
hwclock.sh: mountdevsubfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh keyboard-setup
mountall-bootclean.sh: mountall.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
bootmisc.sh: mountall-bootclean.sh mountnfs-bootclean.sh udev checkroot-bootclean.sh
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
kmod: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
checkfs.sh: checkroot.sh
procps: mountkernfs.sh udev
