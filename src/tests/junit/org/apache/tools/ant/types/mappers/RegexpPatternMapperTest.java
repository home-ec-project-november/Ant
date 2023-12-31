/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.tools.ant.types.mappers;

import org.apache.tools.ant.BuildFileRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Testcase for the &lt;regexpmapper&gt; mapper.
 *
 */
public class RegexpPatternMapperTest {

    @Rule
    public BuildFileRule buildRule = new BuildFileRule();

    @Before
    public void setUp() {
        buildRule.configureProject("src/etc/testcases/types/mappers/regexpmapper.xml");
    }

    @Test
    public void testIgnoreCase() {
        buildRule.executeTarget("ignore.case");
    }

    @Test
    public void testHandleDirSep() {
        buildRule.executeTarget("handle.dirsep");
    }

    /**
     * Test that if the {@code to} attribute of {@code regexpmapper} contains a backslash
     * character which isn't followed by a digit (representing regex group) then the backslash
     * doesn't disappear from the output. See bug 66468 for details
     */
    @Test
    public void testBackslashInTo() {
        buildRule.executeTarget("to-with-backslash-for-non-groups");
    }
}
