SUMMARY = "Environment sensor daemon"
DESCRIPTION = "Basic template recipe for the envsensord service."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

# Replace with your real source (git, tarball, local files, etc.)
# Example for a local file in the layer:
#   FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
#   SRC_URI = "file://envsensord.c"
SRC_URI = ""

S = "${WORKDIR}/sources"

# Inherit a build class appropriate for your project, e.g.:
# inherit cmake
# inherit autotools
# inherit pkgconfig

do_unpack[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
	# Install binaries, configs, and service files here.
	# Example for a single binary:
	# install -d ${D}${bindir}
	# install -m 0755 envsensord ${D}${bindir}/envsensord

	# Example for a systemd service file:
	# install -d ${D}${systemd_system_unitdir}
	# install -m 0644 ${WORKDIR}/envsensord.service \
	#     ${D}${systemd_system_unitdir}/envsensord.service
	:
}

FILES:${PN} += "${bindir} ${sbindir} ${sysconfdir} ${systemd_system_unitdir}"

# If you add a systemd service, you can enable systemd integration like this:
# inherit systemd
# SYSTEMD_SERVICE:${PN} = "envsensord.service"
