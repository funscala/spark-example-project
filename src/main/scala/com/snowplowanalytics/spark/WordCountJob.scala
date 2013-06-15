/*
 * Copyright (c) 2012-2013 SnowPlow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.spark

object WordCountJob {
  
  def main(args: Array[String]) {
        
    // Run the word count
    WordCount.execute(
      master    = sys.env("MASTER"),
      args      = allButFirst(args),
      sparkHome = Option(sys.env("SPARK_HOME")),
      jars      = args.headOption.map(j => Seq(j))
    )

    // Exit with success
    System.exit(0)
  }

  def allButFirst(args: Array[String]) = {
    val len = args.length - 1
    if (len >= 1) {
      args.takeRight(len)
    } else {
      null // Yech, really should switch this to an empty Scala List
    }
  }
}
