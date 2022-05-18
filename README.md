# ViewPagerAdapter

## ViewPager、ViewPager2的Adapter。

[![](https://jitpack.io/v/FPhoenixCorneaE/ViewPagerAdapter.svg)](https://jitpack.io/#FPhoenixCorneaE/ViewPagerAdapter)

### How to include it in your project:

**Step 1.** Add the JitPack repository to your build file.

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url "https://jitpack.io"
        }
    }
}
```

**Step 2.** Add the dependency.

```groovy
dependencies {
    implementation("com.github.FPhoenixCorneaE:ViewPagerAdapter:$latest")
}
```

### How to use:

#### FragmentPagerItemAdapter

```kotlin
FragmentPagerItemAdapter(
    this@MainActivity,
    FragmentPagerItems.with(this@MainActivity)
        .apply {
            titleList.forEach {
                add(
                    title = it,
                    clazz = SampleFragment::class.java,
                    args = Bundle().apply { putString("title", it) },
                    width = 0.25f
                )
            }
        }
        .create()
)
```

#### FragmentStatePagerItemAdapter

```kotlin
FragmentStatePagerItemAdapter(
    this@MainActivity,
    FragmentPagerItems.with(this@MainActivity)
        .apply {
            titleList.forEach {
                add(
                    title = it,
                    clazz = SampleFragment::class.java,
                    args = Bundle().apply { putString("title", it) },
                    width = 0.5f
                )
            }
        }
        .create(),
)
```

#### ViewPagerItemAdapter

```kotlin
ViewPagerItemAdapter(
    ViewPagerItems.with(this@MainActivity)
        .apply {
            titleList.forEach {
                add(title = it, layoutResId = R.layout.layout_pager, width = 0.8f)
            }
        }
        .create(),
)
```

#### FragmentStatePager2ItemAdapter

```kotlin
FragmentStatePager2ItemAdapter(
    this@MainActivity,
    FragmentPagerItems.with(this@MainActivity)
        .apply {
            titleList.forEach {
                add(
                    title = it,
                    clazz = SampleFragment::class.java,
                    args = Bundle().apply { putString("title", it) },
                    width = 1f
                )
            }
        }
        .create()
)
```