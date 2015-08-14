SUMMARY = "DragonBoard 410c 96Boards firmware"
DESCRIPTION = "Qualcomm 96Boards firmware such as for the DB410C"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=fb3bff92a85d4423f0d10238b27f777d"

SRC_URI = "file://linux-ubuntu-board-support-package-v1.zip \
          file://LICENSE \
"
SRC_URI[md5sum] = "56dbab39e3e779a4a55c659695c2a4e9"
SRC_URI[sha256sum] = "43a3f71296e07f8449538801a9f510ad876bc2997e9337e512c85938a6d959aa"

inherit allarch

do_install() {
    tar xzf ${WORKDIR}/proprietary-ubuntu-1.tgz
    install -d ${D}/lib/firmware
    cp -rfv proprietary-ubuntu-1/* ${D}/lib/firmware/
    find ${D}/lib/firmware -type f -exec chmod 644 '{}' ';'
}

FILES_${PN} = "/lib/firmware/"

# QA complains about arch specific files
INSANE_SKIP_${PN} = "arch"
