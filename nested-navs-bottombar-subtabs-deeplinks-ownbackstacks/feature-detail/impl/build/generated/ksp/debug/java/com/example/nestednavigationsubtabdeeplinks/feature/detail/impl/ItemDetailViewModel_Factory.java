package com.example.nestednavigationsubtabdeeplinks.feature.detail.impl;

import com.example.nestednavigationsubtabdeeplinks.data.HomeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class ItemDetailViewModel_Factory {
  private final Provider<HomeRepository> repositoryProvider;

  private ItemDetailViewModel_Factory(Provider<HomeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public ItemDetailViewModel get(int id) {
    return newInstance(id, repositoryProvider.get());
  }

  public static ItemDetailViewModel_Factory create(Provider<HomeRepository> repositoryProvider) {
    return new ItemDetailViewModel_Factory(repositoryProvider);
  }

  public static ItemDetailViewModel newInstance(int id, HomeRepository repository) {
    return new ItemDetailViewModel(id, repository);
  }
}
