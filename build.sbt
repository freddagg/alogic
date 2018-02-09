////////////////////////////////////////////////////////////////////////////////
// Argon Design Ltd. Project P8009 Alogic
// Copyright (c) 2017 Argon Design Ltd. All rights reserved.
//
// Module : Scala Alogic Compiler
// Author : Peter de Rivaz/Geza Lore
//
// DESCRIPTION:
//
//
// This file is covered by the BSD (with attribution) license.
// See the LICENSE file for the precise wording of the license.
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// About the project
////////////////////////////////////////////////////////////////////////////////

name := "alogic"

organization := "Argon Design"

version := "1"

////////////////////////////////////////////////////////////////////////////////
// Scala compiler
////////////////////////////////////////////////////////////////////////////////

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation", "-feature", "-Xlint:_")

////////////////////////////////////////////////////////////////////////////////
// Library dependencies
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// Testing dependencies
////////////////////////////////////////////////////////////////////////////////

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

logBuffered in Test := false

////////////////////////////////////////////////////////////////////////////////
// Antlr4 plugin
////////////////////////////////////////////////////////////////////////////////

enablePlugins(Antlr4Plugin)

antlr4Version in Antlr4 := "4.7.1"

antlr4PackageName in Antlr4 := Some("alogic.antlr")

antlr4GenListener in Antlr4 := false

antlr4GenVisitor in Antlr4 := true

////////////////////////////////////////////////////////////////////////////////
// SBT native packager
////////////////////////////////////////////////////////////////////////////////

enablePlugins(JavaAppPackaging)

// Prepend '--' to the command line arguments in the wrapper script.
// This in fact causes the wrapper script to not consume any arguments,
// in particular -D options
bashScriptExtraDefines += """set -- -- "$@""""
