FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://usb-serial.cfg"
DELTA_KERNEL_DEFCONFIG += "usb-serial.cfg"
