/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.lite.console;

import com.dangdang.ddframe.job.lite.console.restful.LiteJobRestfulApi;
import com.dangdang.ddframe.job.restful.RestfulServer;
import com.dangdang.ddframe.job.security.WwwAuthFilter;
import com.google.common.base.Optional;

public class Bootstrap {
    
    private static final String CONSOLE_PATH = "console";
    
    private static final int PORT = 8899;
    
    /**
     * 启动Restful服务.
     */
    //CHECKSTYLE:OFF
    public static void main(final String[] args) throws Exception {
    //CHECKSTYLE:ON
        RestfulServer restfulServer = new RestfulServer(PORT);
        restfulServer.addFilter(WwwAuthFilter.class, "/")
                     .addFilter(WwwAuthFilter.class, "*.html")
                     .start(LiteJobRestfulApi.class.getPackage().getName(), Optional.of(CONSOLE_PATH));
    }
}
