/**
 *  Copyright (c) 2016 Intel Corporation 
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.spark.ml.org.trustedanalytics.sparktk.deeptrees.util

import org.apache.spark.sql.SQLContext
import org.apache.spark.{ SparkConf, SparkContext }
import org.scalatest.{ BeforeAndAfterAll, Suite }
import org.trustedanalytics.sparktk.testutils.TestingSparkContext

trait MLlibTestSparkContext extends BeforeAndAfterAll { self: Suite =>
  var sc: SparkContext = null
  var sqlContext: SQLContext = _

  override def beforeAll() {
    sc = TestingSparkContext.sparkContext
    sqlContext = SQLContext.getOrCreate(sc)
  }

  override def afterAll() {
    TestingSparkContext.cleanUp()
    sc = null
  }
}
