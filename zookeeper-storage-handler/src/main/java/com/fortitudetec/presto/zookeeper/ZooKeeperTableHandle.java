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

import com.facebook.presto.spi.SchemaTableName;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fortitudetec.presto.BaseTableHandle;

public class ZooKeeperTableHandle implements BaseTableHandle {

  private final SchemaTableName _tableName;
  private final String _connectorId;

  @JsonCreator
  public ZooKeeperTableHandle(@JsonProperty("connectorId") String connectorId,
      @JsonProperty("tableName") SchemaTableName tableName) {
    _connectorId = connectorId;
    _tableName = tableName;
  }

  @JsonProperty
  public SchemaTableName getTableName() {
    return _tableName;
  }

  @JsonProperty
  public String getConnectorId() {
    return _connectorId;
  }

  @Override
  public String toString() {
    return "ZooKeeperTableHandle [_tableName=" + _tableName + ", _connectorId=" + _connectorId + "]";
  }

}
