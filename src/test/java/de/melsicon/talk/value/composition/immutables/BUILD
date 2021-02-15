load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_library(
    name = "tests",
    testonly = True,
    srcs = glob(["*.java"]),
    deps = [
        "//src/main/java/de/melsicon/talk/value/composition/immutables",
        # "//toolchain:checker",
        "//toolchain:nullaway",
        "@maven//:com_google_guava_guava",
        "//toolchain:truth",
    ],
)

java_test(
    name = "MovieTicketTest",
    size = "small",
    runtime_deps = [
        ":tests",
    ],
)
