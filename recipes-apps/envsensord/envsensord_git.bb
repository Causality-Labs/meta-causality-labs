SUMMARY = "Environment sensor daemon"
DESCRIPTION = "Daemon and CLI for reading and exposing environmental sensor data (temperature, humidity, pressure)."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"
PV = "1.1.0+git"

inherit cmake update-rc.d systemd

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

INITSCRIPT_NAME = "envsensord"
INITSCRIPT_PARAMS = "defaults 80 20"

SYSTEMD_SERVICE:${PN} = "envsensord.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += "${bindir} ${sysconfdir}/init.d"

SRC_URI = "git://github.com/Causality-Labs/envsensord.git;protocol=https;branch=main \
           file://envsensord.sh \
           file://envsensord.service \
"
SRCREV = "90ab28f83c5b4bb88909965e18d0319f8b745508"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/bin/envsensord ${D}${bindir}/envsensord
	install -m 0755 ${B}/bin/envsensor-cli ${D}${bindir}/envsensor-cli

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/envsensord.sh ${D}${sysconfdir}/init.d/envsensord

	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/envsensord.service ${D}${systemd_system_unitdir}/envsensord.service
}
