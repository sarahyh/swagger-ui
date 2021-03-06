import Build._

organization := "org.webjars"

name := "swagger-ui-shai"

version := "2.1.2-SNAPSHOT"

crossPaths := false

gulp := { "C:\\Users\\sarahlee\\AppData\\Roaming\\npm\\gulp.cmd".! }

packageBin in Compile <<= (packageBin in Compile) dependsOn gulp

mappings in (Compile, packageBin) := {
  val distDir = baseDirectory.value / "dist"
  val files = distDir ** "*"
  val webjarContentsDir = s"META-INF/resources/webjars/${name.value}/${version.value}"
  files pair rebase(distDir, webjarContentsDir)
}

publishMavenStyle := false

// NOTE: `sbt publish` will NOT work unless you set the shaiIvyRepo key (see local.sbt.example)
//publishTo := Some(shaiIvyRepo.value)
