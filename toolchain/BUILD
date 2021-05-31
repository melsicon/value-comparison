load("@bazel_tools//tools/jdk:default_java_toolchain.bzl", "default_java_toolchain")
load("@rules_java//java:defs.bzl", "java_library", "java_package_configuration", "java_plugin")

alias(
    name = "remote_jdk15",
    actual = select(
        {
            "@bazel_tools//src/conditions:darwin_x86_64": "@remotejdk15_macos//:jdk",
            "@bazel_tools//src/conditions:darwin_arm64": "@remotejdk15_macos_aarch64//:jdk",
            "@bazel_tools//src/conditions:windows": "@remotejdk15_win//:jdk",
            "@bazel_tools//src/conditions:linux_x86_64": "@remotejdk15_linux//:jdk",
            "@bazel_tools//src/conditions:linux_aarch64": "@remotejdk15_linux_aarch64//:jdk",
        },
        no_match_error = "Could not find a JDK for host execution environment, please explicitly" +
                         " provide one using `--host_javabase.`",
    ),
    visibility = ["//visibility:public"],
)

"@bazel_tools//tools/jdk:current_java_runtime"

default_java_toolchain(
    name = "toolchain_java11",
    package_configuration = [
        ":src_package_configuration",
        ":external_package_configuration",
    ],
    # java_runtime = ":remote_jdk15",
    source_version = "11",
    target_version = "11",
    visibility = ["//visibility:public"],
    # javacopts = ["--enable-preview"],
    xlint = [
        "all",
        "-processing",
    ],
)

java_package_configuration(
    name = "src_package_configuration",
    javacopts = [
        "-ArequirePrefixInWarningSuppressions",
        "-AwarnUnneededSuppressions",
        "-AshowSuppressWarningsStrings",
        "-Werror",
        "-Xpkginfo:always",
        "-XepExcludedPaths:.*/_javac/.*",
        "-XepDisableWarningsInGeneratedCode",
        "-XepAllDisabledChecksAsWarnings",
        "-Xep:Java7ApiChecker:OFF",
        "-Xep:AndroidJdkLibsChecker:OFF",
        "-Xep:StaticOrDefaultInterfaceMethod:OFF",
        "-Xep:NoFunctionalReturnType:OFF",
        "-Xep:WildcardImport:OFF",
    ],
    packages = [":src_package_group"],
)

package_group(
    name = "src_package_group",
    packages = [
        "//src/...",
    ],
)

java_package_configuration(
    name = "external_package_configuration",
    javacopts = [
        "-Xlint:none",
    ],
    packages = [":external_package_group"],
)

package_group(
    name = "external_package_group",
    packages = [
        "-//src/...",
        "//...",
    ],
)

# ---
# https://checkerframework.org/manual/#nullness-checker
# https://checkerframework.org/manual/#optional-checker

java_plugin(
    name = "nullness_checker",
    processor_class = "org.checkerframework.checker.nullness.NullnessChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_plugin(
    name = "optional_checker",
    processor_class = "org.checkerframework.checker.optional.OptionalChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_library(
    name = "checker",
    exported_plugins = ["nullness_checker", "optional_checker"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_checkerframework_checker_qual"],
)

# ---
# https://github.com/google/auto/blob/master/value/userguide/index.md

java_plugin(
    name = "auto_value_processor",
    processor_class = "com.google.auto.value.processor.AutoValueProcessor",
    deps = ["@maven//:com_google_auto_value_auto_value"],
)

java_plugin(
    name = "auto_oneof_processor",
    processor_class = "com.google.auto.value.processor.AutoOneOfProcessor",
    deps = ["@maven//:com_google_auto_value_auto_value"],
)

java_plugin(
    name = "auto_annotation_processor",
    processor_class = "com.google.auto.value.processor.AutoAnnotationProcessor",
    deps = ["@maven//:com_google_auto_value_auto_value"],
)

java_library(
    name = "autovalue",
    exported_plugins = [
        "auto_value_processor",
        "auto_oneof_processor",
        "auto_annotation_processor",
    ],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_google_auto_value_auto_value_annotations",
    ],
)

# ---
# https://freebuilder.inferred.org

java_plugin(
    name = "freebuilder_processor",
    generates_api = True,
    processor_class = "org.inferred.freebuilder.processor.Processor",
    deps = ["@maven//:org_inferred_freebuilder"],
)

java_library(
    name = "freebuilder",
    exported_plugins = ["freebuilder_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_inferred_freebuilder",
    ],
)

# ---
# https://immutables.github.io

java_plugin(
    name = "immutables_processor",
    generates_api = True,
    processor_class = "org.immutables.value.processor.Processor",
    deps = ["@maven//:org_immutables_value_processor"],
)

java_library(
    name = "immutables",
    exported_plugins = ["immutables_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_immutables_value_annotations",
    ],
)

# ---
# https://projectlombok.org/features/all

java_plugin(
    name = "lombok_processor",
    generates_api = True,
    processor_class = "lombok.launch.AnnotationProcessorHider$AnnotationProcessor",
    deps = ["@maven//:org_projectlombok_lombok"],
)

java_library(
    name = "lombok",
    data = [
        "//:lombok.config",
    ],
    exported_plugins = ["lombok_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_projectlombok_lombok",
    ],
)

# ---
# https://truth.dev

java_library(
    name = "truth",
    testonly = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_google_truth_extensions_truth_java8_extension",
        "@maven//:com_google_truth_truth",
        "@maven//:junit_junit",
        "@maven//:org_ow2_asm_asm",
    ],
)
