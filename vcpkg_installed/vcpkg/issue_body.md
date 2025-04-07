Package: libiconv:x64-windows -> 1.17#1

**Host Environment**

- Host: x64-windows
- Compiler: MSVC 19.38.33135.0
-    vcpkg-tool version: 2023-09-15-ac02a9f660977426b8ec6392919fbb1d51b10998
    vcpkg-readonly: true
    vcpkg-scripts version: 2c401863dd54a640aeb26ed736c55489c079323b

**To Reproduce**

`vcpkg install `
**Failure logs**

```
-- Using cached libiconv-1.17.tar.gz.
-- Cleaning sources at E:/Electro/ECMS/vcpkg_installed/vcpkg/blds/libiconv/src/v1.17-84a471678e.clean. Use --editable to skip cleaning for the packages you specify.
-- Extracting source C:/Users/segfault/AppData/Local/vcpkg/downloads/libiconv-1.17.tar.gz
-- Applying patch 0002-Config-for-MSVC.patch
-- Applying patch 0003-Add-export.patch
-- Applying patch 0004-ModuleFileName.patch
-- Applying patch clang-fortify.patch
-- Using source at E:/Electro/ECMS/vcpkg_installed/vcpkg/blds/libiconv/src/v1.17-84a471678e.clean
-- Found external ninja('1.11.0').
-- Getting CMake variables for x64-windows
-- Using cached msys2-autoconf-wrapper-20221207-1-any.pkg.tar.zst.
-- Using cached msys2-automake-wrapper-20221207-1-any.pkg.tar.zst.
-- Using cached msys2-binutils-2.40-1-x86_64.pkg.tar.zst.
-- Using cached msys2-libtool-2.4.7-3-x86_64.pkg.tar.zst.
-- Using cached msys2-make-4.4.1-1-x86_64.pkg.tar.zst.
-- Using cached msys2-pkgconf-1.9.4-1-x86_64.pkg.tar.zst.
-- Using cached msys2-which-2.21-4-x86_64.pkg.tar.zst.
-- Using cached msys2-bash-5.2.015-1-x86_64.pkg.tar.zst.
-- Using cached msys2-coreutils-8.32-5-x86_64.pkg.tar.zst.
-- Using cached msys2-file-5.44-5-x86_64.pkg.tar.zst.
-- Downloading https://mirror.msys2.org/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst;https://repo.msys2.org/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst;https://mirror.yandex.ru/mirrors/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst;https://mirrors.tuna.tsinghua.edu.cn/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst;https://mirrors.ustc.edu.cn/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst;https://mirror.selfnet.de/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst -> msys2-gawk-5.2.1-2-x86_64.pkg.tar.zst...
[DEBUG] To include the environment variables in debug output, pass --debug-env
[DEBUG] Trying to load bundleconfig from E:\vs2022\VC\vcpkg\vcpkg-bundle.json
[DEBUG] Bundle config: readonly=true, usegitregistry=true, embeddedsha=2c401863dd54a640aeb26ed736c55489c079323b, deployment=VisualStudio, vsversion=17.0
[DEBUG] VS telemetry opted in at SOFTWARE\WOW6432Node\Microsoft\VSCommon\17.0\SQM\\OptIn
[DEBUG] Metrics enabled.
[DEBUG] Feature flag 'binarycaching' unset
[DEBUG] Feature flag 'compilertracking' unset
[DEBUG] Feature flag 'registries' unset
[DEBUG] Feature flag 'versions' unset
[DEBUG] Feature flag 'dependencygraph' unset
Downloading https://mirror.msys2.org/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst
Downloading https://repo.msys2.org/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst
Downloading https://mirror.yandex.ru/mirrors/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst
Downloading https://mirrors.tuna.tsinghua.edu.cn/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst
Downloading https://mirrors.ustc.edu.cn/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst
Downloading https://mirror.selfnet.de/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst
error: Failed to download from mirror set
error: https://mirror.msys2.org/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst: failed: status code 404
error: https://repo.msys2.org/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirror.yandex.ru/mirrors/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirrors.tuna.tsinghua.edu.cn/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirrors.ustc.edu.cn/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirror.selfnet.de/msys2/msys/x86_64/gawk-5.2.1-2-x86_64.pkg.tar.zst: failed: status code 404
[DEBUG] D:\a\_work\1\s\src\vcpkg\base\downloads.cpp(1051): 
[DEBUG] Time in subprocesses: 0us
[DEBUG] Time in parsing JSON: 23us
[DEBUG] Time in JSON reader: 0us
[DEBUG] Time in filesystem: 4560us
[DEBUG] Time in loading ports: 0us
[DEBUG] Exiting after 5.3 s (5294546us)

CMake Error at scripts/cmake/vcpkg_download_distfile.cmake:32 (message):
      
      Failed to download file with error: 1
      If you are using a proxy, please check your proxy setting. Possible causes are:
      
      1. You are actually using an HTTP proxy, but setting HTTPS_PROXY variable
         to `https://address:port`. This is not correct, because `https://` prefix
         claims the proxy is an HTTPS proxy, while your proxy (v2ray, shadowsocksr
         , etc..) is an HTTP proxy. Try setting `http://address:port` to both
         HTTP_PROXY and HTTPS_PROXY instead.
      
      2. If you are using Windows, vcpkg will automatically use your Windows IE Proxy Settings
         set by your proxy software. See https://github.com/microsoft/vcpkg-tool/pull/77
         The value set by your proxy might be wrong, or have same `https://` prefix issue.
      
      3. Your proxy's remote server is out of service.
      
      If you've tried directly download the link, and believe this is not a temporary
      download server failure, please submit an issue at https://github.com/Microsoft/vcpkg/issues
      to report this upstream download server failure.
      

Call Stack (most recent call first):
  scripts/cmake/vcpkg_download_distfile.cmake:270 (z_vcpkg_download_distfile_show_proxy_and_fail)
  scripts/cmake/vcpkg_acquire_msys.cmake:25 (vcpkg_download_distfile)
  scripts/cmake/vcpkg_acquire_msys.cmake:124 (z_vcpkg_acquire_msys_download_package)
  scripts/cmake/vcpkg_acquire_msys.cmake:209 (z_vcpkg_acquire_msys_download_packages)
  scripts/cmake/vcpkg_configure_make.cmake:228 (vcpkg_acquire_msys)
  C:/Users/segfault/AppData/Local/vcpkg/registries/git-trees/4226589d5d658f4d96df83f8539de54dc57a5996/portfile.cmake:29 (vcpkg_configure_make)
  scripts/ports.cmake:147 (include)



```
**Additional context**

<details><summary>vcpkg.json</summary>

```
{
  "dependencies": [
    "fltk"
  ]
}

```
</details>
