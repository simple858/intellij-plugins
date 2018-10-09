// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.angular2.entities.impl;

import com.intellij.lang.javascript.psi.JSElement;
import com.intellij.lang.javascript.psi.JSRecordType;
import com.intellij.lang.javascript.psi.JSType;
import org.angular2.entities.Angular2DirectiveProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Angular2SourceDirectiveProperty implements Angular2DirectiveProperty {

  private final JSRecordType.PropertySignature mySignature;
  private final String myName;

  public Angular2SourceDirectiveProperty(@NotNull JSRecordType.PropertySignature signature, @NotNull String bindingName) {
    mySignature = signature;
    myName = bindingName;
    assert mySignature.getMemberSource().getSingleElement() != null;
  }

  @NotNull
  @Override
  public String getName() {
    return myName;
  }

  @Nullable
  @Override
  public JSType getType() {
    return mySignature.getType();
  }

  @NotNull
  @Override
  public JSElement getNavigableElement() {
    return Objects.requireNonNull((JSElement)mySignature.getMemberSource().getSingleElement());
  }
}
