workspace(name = "de_melsicon_value_comparison")

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

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_proto",
    sha256 = "bc12122a5ae4b517fa423ea03a8d82ea6352d5127ea48cb54bc324e8ab78493c",
    strip_prefix = "rules_proto-af6481970a34554c6942d993e194a9aed7987780",
    url = "https://github.com/bazelbuild/rules_proto/archive/af6481970a34554c6942d993e194a9aed7987780.tar.gz",
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

# ---

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "5c97a74dfd1e2012643735311670945f16223935d297a0467ec49fb8d787ef64",
    strip_prefix = "rules_scala-e7a948ad1948058a7a5ddfbd9d1629d6db839933",
    url = "https://github.com/bazelbuild/rules_scala/archive/e7a948ad1948058a7a5ddfbd9d1629d6db839933.tar.gz",
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "2.13.3")

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")

scala_repositories()

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()

# ---

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "eeae65f973b70896e474c57aa7681e444d7a5446d9ec0a59bb88c59fc263ff62",
    url = "https://github.com/bazelbuild/rules_kotlin/releases/download/v1.5.0-alpha-3/rules_kotlin_release.tgz",
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()

# ---

maven_install(
    artifacts = [
        "com.google.auto.value:auto-value-annotations:1.8.2",
        "com.google.auto.value:auto-value:1.8.2",
        "com.google.errorprone:error_prone_annotations:2.7.1",
        "com.google.flogger:flogger-system-backend:0.6",
        "com.google.flogger:flogger:0.6",
        "com.google.guava:guava:30.1.1-jre",
        "commons-validator:commons-validator:1.7",
        "org.checkerframework:checker-qual:3.16.0",
        "org.checkerframework:checker:3.16.0",
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
