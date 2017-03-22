pgpPassphrase := Some(getEnvVar("PGP_PASSPHRASE").getOrElse("").toCharArray)
pgpPublicRing := file(s"$gpgFolder/pubring.gpg")
pgpSecretRing := file(s"$gpgFolder/secring.gpg")

lazy val `sbt-microsites` = (project in file("."))
  .settings(moduleName := "sbt-microsites")
  .settings(pluginSettings: _*)
  .settings(tutSettings: _*)
  .settings(testScriptedSettings: _*)
  .enablePlugins(JekyllPlugin)
  .enablePlugins(AutomateHeaderPlugin)

lazy val docs = (project in file("docs"))
  .settings(moduleName := "docs")
  .settings(micrositeSettings: _*)
  .settings(noPublishSettings: _*)
  .settings(buildInfoSettings: _*)
  .enablePlugins(MicrositesPlugin)
  .enablePlugins(BuildInfoPlugin)

lazy val kazari = (project in file("kazari"))
  .settings(moduleName := "kazari")
  .settings(jsSettings: _*)
  .settings(KazariBuild.kazariTasksSettings: _*)
  .enablePlugins(ScalaJSPlugin)
