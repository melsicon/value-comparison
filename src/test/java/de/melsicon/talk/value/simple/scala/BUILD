load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_library(
    name = "tests",
    testonly = True,
    srcs = glob(["*.java"]),
    deps = [
        "//src/main/scala/de/melsicon/talk/value/simple/scala",
        "//toolchain:checker",
        "//toolchain:truth",
        "@maven//:com_google_errorprone_error_prone_annotations",
    ],
)

java_test(
    name = "EmailAddressTest",
    size = "small",
    runtime_deps = [
        ":tests",
    ],
)

java_test(
    name = "PersonTest",
    size = "small",
    runtime_deps = [
        ":tests",
    ],
)
