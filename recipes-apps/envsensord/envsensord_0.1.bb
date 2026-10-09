SUMMARY = "Environment sensor daemon"
DESCRIPTION = "Daemon and CLI for reading and exposing environmental sensor data (temperature, humidity, pressure)."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

inherit update-rc.d

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

INITSCRIPT_NAME = "envsensord"
INITSCRIPT_PARAMS = "defaults 80 20"

FILES:${PN} += "${bindir} ${sysconfdir}/init.d"

SRC_URI = "git://github.com/Causality-Labs/envsensord.git;protocol=https;branch=main \
           file://envsensord.sh \
"
SRCREV = "13187844f4b1c80a94bea26a8f94ed1f0152c4bb"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 bin/envsensord ${D}${bindir}/envsensord
	install -m 0755 bin/envsensor-cli ${D}${bindir}/envsensor-cli

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/envsensord.sh ${D}${sysconfdir}/init.d/envsensord
}
