package com.example.nestednavigationsubtabdeeplinks.feature.detail.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class ItemDetailViewModel_Factory_Impl implements ItemDetailViewModel.Factory {
  private final ItemDetailViewModel_Factory delegateFactory;

  ItemDetailViewModel_Factory_Impl(ItemDetailViewModel_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public ItemDetailViewModel create(int id) {
    return delegateFactory.get(id);
  }

  public static Provider<ItemDetailViewModel.Factory> create(
      ItemDetailViewModel_Factory delegateFactory) {
    return InstanceFactory.create(new ItemDetailViewModel_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<ItemDetailViewModel.Factory> createFactoryProvider(
      ItemDetailViewModel_Factory delegateFactory) {
    return InstanceFactory.create(new ItemDetailViewModel_Factory_Impl(delegateFactory));
  }
}
