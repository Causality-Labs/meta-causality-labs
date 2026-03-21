SUMMARY = "Environment sensor daemon"
DESCRIPTION = "Basic template recipe for the envsensord service."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

# FILES:${PN} += "${bindir} ${sbindir} ${sysconfdir} ${systemd_system_unitdir}"

# If you add a systemd service, you can enable systemd integration like this:
# inherit systemd
# SYSTEMD_SERVICE:${PN} = "envsensord.service"
FILES:${PN} += "${bindir}"

SRC_URI = "git://github.com/Causality-Labs/envsensord.git;protocol=https;branch=main"
SRCREV = "13187844f4b1c80a94bea26a8f94ed1f0152c4bb"
S = "${WORKDIR}/git"

do_install() {
	# Install binaries, configs, and service files here.
	# Example for a single binary:
	# install -d ${D}${bindir}
	# install -m 0755 envsensord ${D}${bindir}/envsensord

	# Example for a systemd service file:
	# install -d ${D}${systemd_system_unitdir}
	# install -m 0644 ${WORKDIR}/envsensord.service \
	#     ${D}${systemd_system_unitdir}/envsensord.service
	install -d ${D}${bindir}
	install -m 0755 bin/envsensord ${D}${bindir}/envsensord
	install -m 0755 bin/envsensor-cli ${D}${bindir}/envsensor-cli
}
