/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.example.project;

import java.lang.ref.Cleaner;

/**
 * The package and API for Cleaner changed from Java 8 to Java 9+.
 * This extracts the java 9+ `java.lang.ref.Cleaner` into a standalone class.
 */
public class MemoryCleaner {
  private final Cleaner cleaner = Cleaner.create();
  private final Cleaner.Cleanable cleanable;

  /**
   * Creates a new `java.lang.ref.Cleaner`.
   * @param referent the object to be cleaned
   * @param deallocator - the cleanup code to be run when the cleaner is invoked.
   */
  public MemoryCleaner(final Object referent, final Runnable deallocator) {
      this.cleanable = cleaner.register(referent, deallocator);
  }

  /**
   * Runs this cleaner.
   */
    public void clean() {
        cleanable.clean();
    }
}

