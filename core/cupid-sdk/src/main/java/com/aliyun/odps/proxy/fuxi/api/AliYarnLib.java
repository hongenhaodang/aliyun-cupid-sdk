/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyun.odps.proxy.fuxi.api;

import java.lang.reflect.Constructor;

public abstract class AliYarnLib {

    private static AliYarnLib instance = null;

    protected AliYarnLib() {
    }

    public static AliYarnLib getInstance() {
        if (instance == null) {
            try {
                Class clz = Class.forName("com.aliyun.odps.proxy.fuxi.api.impl.AliYarnLibImpl");
                Constructor<AliYarnLib> meth = (Constructor<AliYarnLib>) clz.getDeclaredConstructor(new Class[]{});
                meth.setAccessible(true);
                instance = meth.newInstance();
            } catch (Exception e) {
                System.err.println("AliYarnLib initialized failed: " + e.toString());
                e.printStackTrace(System.err);
            }
        }
        return instance;
    }

    public abstract String postToFuxi(String url, String request);

}
