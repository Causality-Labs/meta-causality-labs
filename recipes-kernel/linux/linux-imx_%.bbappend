FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Added-bme280-to-the-imx91-dts.patch"
SRC_URI += "file://bmp.cfg"

DELTA_KERNEL_DEFCONFIG = "bmp.cfg"
