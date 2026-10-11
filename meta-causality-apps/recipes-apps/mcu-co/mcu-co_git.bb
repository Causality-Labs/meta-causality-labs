SUMMARY = "Host library and CLI for the mcu-co MCU co-processor"
DESCRIPTION = "libmcuco and mcu-co-cli for talking to the mcu-co MCU co-processor over UART."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f4615aa2399cec015d79b71a1d348fd4"

SRC_URI = "git://github.com/Causality-Labs/mcu-co_sdk.git;protocol=https;branch=main"
SRCREV = "6a8455ac081cd587d6321ce9623becaa141ea5c5"
PV = "0.1.0+git"
S = "${WORKDIR}/git"

inherit cmake

# Needed to use unit tests
EXTRA_OECMAKE = "-DBUILD_TESTING=OFF"

PACKAGES =+ "${PN}-examples"
FILES:${PN}-examples = " \
    ${bindir}/mcu-co-blink \
    ${bindir}/mcu-co-pwm_frequency \
    ${bindir}/mcu-co-irq_bind \
    ${bindir}/mcu-co-pwm_breathe \
"

# Upstream builds the examples but doesn't install them
do_install:append() {
    install -m 0755 ${B}/examples/blink ${D}${bindir}/mcu-co-blink
    install -m 0755 ${B}/examples/pwm_frequency ${D}${bindir}/mcu-co-pwm_frequency
    install -m 0755 ${B}/examples/irq_bind ${D}${bindir}/mcu-co-irq_bind
    install -m 0755 ${B}/examples/pwm_breathe ${D}${bindir}/mcu-co-pwm_breathe
}
