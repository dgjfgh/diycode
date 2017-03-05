/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-03-03 14:32:34
 *
 */

package com.gcssloop.diycode_sdk.api.test.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gcssloop.diycode_sdk.api.base.callback.BaseCallback;
import com.gcssloop.diycode_sdk.api.base.implement.BaseImplement;
import com.gcssloop.diycode_sdk.api.test.Event.HelloEvent;
import com.gcssloop.diycode_sdk.utils.UUIDGenerator;

public class TestImplement extends BaseImplement<TestService> implements TestAPI {
    public TestImplement(@NonNull Context context) {
        super(context);
    }

    /**
     * 简单的 API 测试接口，需要登录验证，便于快速测试 OAuth 以及其他 API 的基本格式是否正确。
     * 使用 HelloEvent 接收结果。
     *
     * @param limit 数量极限，值范围[0..100]
     * @see HelloEvent
     */
    @Override
    public String hello(@Nullable Integer limit) {
        final String uuid = UUIDGenerator.getUUID();
        mService.hello(limit).enqueue(new BaseCallback<>(new HelloEvent(uuid)));
        return uuid;
    }
}