load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_library(
    name = "tests",
    testonly = True,
    srcs = glob(["*.java"]),
    deps = [
        "//src/main/kotlin/de/melsicon/talk/value/simple/kotlin",
        "//toolchain:checker",
        "//toolchain:nullaway",
        "//toolchain:truth",
        "@com_github_jetbrains_kotlin//:kotlin-stdlib",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_guava",
    ],
)

java_test(
    name = "PersonTest",
    size = "small",
    runtime_deps = [
        ":tests",
    ],
)
