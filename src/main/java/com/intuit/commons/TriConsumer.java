/**
 * Copyright 2019 Intuit Inc.
 *
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
 */
package com.intuit.commons;

import java.util.Objects;

/**
 *
 * @author gkesler
 */
@FunctionalInterface
public interface TriConsumer<X, Y, Z> {
    void accept (X x, Y y, Z z);
    
    default TriConsumer<X, Y, Z> andThen (TriConsumer<? super X, ? super Y, ? super Z> after) {
        Objects.requireNonNull(after);
        
        return (X x, Y y, Z z) -> {
            accept(x, y, z);
            after.accept(x, y, z);
        };
    }
}
