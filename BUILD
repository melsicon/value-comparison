load("@rules_java//java:defs.bzl", "java_binary")

exports_files(["lombok.config"])

java_binary(
    name = "value-comparison",
    data = [
        ":conf/logging.properties",
    ],
    jvm_flags = [
        "-Djava.util.logging.config.file=conf/logging.properties",
    ],
    main_class = "de.melsicon.talk.value.Main",
    runtime_deps = [
        "//src/main/java/de/melsicon/talk/value",
        "@maven//:com_google_flogger_flogger_system_backend",
    ],
)
