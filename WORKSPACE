workspace(name = "de_melsicon_value_comparison")

register_toolchains("//toolchain:toolchain_java16_definition")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ---

http_archive(
    name = "bazel_skylib",
    sha256 = "1c531376ac7e5a180e0237938a2536de0c54d93f5c278634818e0efc952dd56c",
    urls = [
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.0.3/bazel-skylib-1.0.3.tar.gz",
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.0.3/bazel-skylib-1.0.3.tar.gz",
    ],
)

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()

# ---

http_archive(
    name = "rules_jvm_external",
    sha256 = "995ea6b5f41e14e1a17088b727dcff342b2c6534104e73d6f06f1ae0422c2308",
    strip_prefix = "rules_jvm_external-4.1",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.1.tar.gz",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

# ---

http_archive(
    name = "rules_proto",
    sha256 = "36476f17a78a4c495b9a9e70bd92d182e6e78db476d90c74bac1f5f19f0d6d04",
    strip_prefix = "rules_proto-fcad4680fee127dbd8344e6a961a28eef5820ef4",
    url = "https://github.com/bazelbuild/rules_proto/archive/fcad4680fee127dbd8344e6a961a28eef5820ef4.tar.gz",
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

# ---

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "0701ee4e1cfd59702d780acde907ac657752fbb5c7d08a0ec6f58ebea8cd0efb",
    strip_prefix = "rules_scala-2437e40131072cadc1628726775ff00fa3941a4a",
    url = "https://github.com/bazelbuild/rules_scala/archive/2437e40131072cadc1628726775ff00fa3941a4a.tar.gz",
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "2.13.6")

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")

scala_repositories()

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()

# ---

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "58edd86f0f3c5b959c54e656b8e7eb0b0becabd412465c37a2078693c2571f7f",
    url = "https://github.com/bazelbuild/rules_kotlin/releases/download/v1.5.0-beta-3/rules_kotlin_release.tgz",
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_register_toolchains")
load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")

kotlin_repositories()

kt_register_toolchains()

# ---

maven_install(
    artifacts = [
        "com.google.auto.value:auto-value-annotations:1.8.2",
        "com.google.auto.value:auto-value:1.8.2",
        "com.google.errorprone:error_prone_annotations:2.9.0",
        "com.google.flogger:flogger-system-backend:0.6",
        "com.google.flogger:flogger:0.6",
        "com.google.guava:guava:30.1.1-jre",
        "commons-validator:commons-validator:1.7",
        "org.checkerframework:checker-qual:3.17.0",
        "org.checkerframework:checker:3.17.0",
        "org.immutables:value-annotations:2.9.0-beta3",
        "org.immutables:value-processor:2.9.0-beta3",
        "org.inferred:freebuilder:2.7.0",
        "org.projectlombok:lombok:1.18.20",
        maven.artifact(
            "com.google.truth",
            "truth",
            "1.1.3",
            testonly = True,
        ),
        maven.artifact(
            "com.google.truth.extensions",
            "truth-java8-extension",
            "1.1.3",
            testonly = True,
        ),
        maven.artifact(
            "junit",
            "junit",
            "4.13.2",
            testonly = True,
        ),
        maven.artifact(
            "org.ow2.asm",
            "asm",
            "9.2",
            testonly = True,
        ),
    ],
    fetch_sources = True,
    maven_install_json = "@de_melsicon_value_comparison//:maven_install.json",
    repositories = [
        "https://maven-central-eu.storage-download.googleapis.com/maven2",
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# ---
