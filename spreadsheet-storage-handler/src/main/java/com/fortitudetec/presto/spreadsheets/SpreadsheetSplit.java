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
package com.fortitudetec.presto.spreadsheets;

import java.util.List;

import com.facebook.presto.spi.HostAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fortitudetec.presto.BaseSplit;
import com.google.common.collect.ImmutableList;

public class SpreadsheetSplit implements BaseSplit {
  private final String _connectorId;
  private final SpreadsheetTableHandle _spreadsheetTableHandle;

  public SpreadsheetSplit(@JsonProperty("connectorId") String connectorId,
      @JsonProperty("spreadsheetTableHandle") SpreadsheetTableHandle spreadsheetTableHandle) {
    _connectorId = connectorId;
    this._spreadsheetTableHandle = spreadsheetTableHandle;
  }

  @JsonProperty
  public String getConnectorId() {
    return _connectorId;
  }

  @JsonProperty
  public SpreadsheetTableHandle getSpreadsheetTableHandle() {
    return _spreadsheetTableHandle;
  }

  @Override
  public boolean isRemotelyAccessible() {
    return true;
  }

  @Override
  public List<HostAddress> getAddresses() {
    return ImmutableList.of();
  }

  @Override
  public Object getInfo() {
    return this;
  }

}
