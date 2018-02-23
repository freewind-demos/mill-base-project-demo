import mill._
import mill.scalalib._

trait MyScalaModule extends ScalaModule { outer =>
  override def scalaVersion = "2.12.4"
  trait MyTests extends Tests {
    override def moduleDeps = outer :: outer.moduleDeps.toList
    override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.0.4")
    override def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}

object hello extends MyScalaModule {
  override def ivyDeps = Agg(
    ivy"org.apache.commons:commons-lang3:3.3.2",
    ivy"org.typelevel::cats-core:1.0.1",
    ivy"com.typesafe.scala-logging::scala-logging:3.7.2",
    ivy"com.chuusai::shapeless:2.3.3",
    ivy"org.mockito:mockito-core:2.13.0",
    ivy"com.softwaremill.sttp::core:1.1.2",
    ivy"org.asynchttpclient:async-http-client:2.0.37",
    ivy"com.softwaremill.sttp::json4s:1.1.2",
    ivy"com.softwaremill.sttp::async-http-client-backend:1.1.2",
    ivy"com.softwaremill.sttp::async-http-client-backend-future:1.1.2",
    ivy"commons-io:commons-io:2.4",
    ivy"org.scala-lang:scala-reflect:${scalaVersion()}"
  )
  object test extends MyTests
}
