load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "value",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/de/melsicon/talk/value/simple/autovalue",
        "//src/main/java/de/melsicon/talk/value/simple/freebuilder",
        "//src/main/java/de/melsicon/talk/value/simple/immutables",
        "//src/main/java/de/melsicon/talk/value/simple/lombok",
        "//src/main/java/de/melsicon/talk/value/simple/pojo",
        "//src/main/java/de/melsicon/talk/value/simple/record",
        "//src/main/scala/de/melsicon/talk/value/simple/scala",
        "//toolchain:checker",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_guava_guava",
    ],
)
