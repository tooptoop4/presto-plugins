/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fortitudetec.presto.zookeeper;

import java.util.List;

import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.ConnectorRecordSetProvider;
import com.facebook.presto.spi.ConnectorSession;
import com.facebook.presto.spi.ConnectorSplit;
import com.facebook.presto.spi.RecordSet;

public class ZooKeeperRecordSetProvider implements ConnectorRecordSetProvider {

  private final String _zkConnection;
  private final int _sessionTimeout;

  public ZooKeeperRecordSetProvider(String zkConnection, int sessionTimeout) {
    _zkConnection = zkConnection;
    _sessionTimeout = sessionTimeout;
  }

  @Override
  public RecordSet getRecordSet(ConnectorSession connectorSession, ConnectorSplit split,
      List<? extends ColumnHandle> columnHandles) {
    return new ZooKeeperRecordSet(_zkConnection, _sessionTimeout, columnHandles);
  }

}
