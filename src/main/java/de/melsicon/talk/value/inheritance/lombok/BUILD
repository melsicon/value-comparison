load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "lombok",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    exports = [
        "//src/main/java/de/melsicon/talk/value/simple/lombok",
    ],
    deps = [
        "//src/main/java/de/melsicon/talk/value/simple/lombok",
        "//toolchain:checker",
        "//toolchain:lombok",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_guava",
    ],
)
