load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "freebuilder",
    srcs = glob(["*.java"]),
    javacopts = [
        "-AskipDefs=_Builder$$",
        "-XepExcludedPaths:.*/_javac/.*",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "//toolchain:freebuilder",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_guava",
        "@maven//:commons_validator_commons_validator",
    ],
)
