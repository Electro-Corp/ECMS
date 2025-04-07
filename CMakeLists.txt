# CMakeList.txt : CMake project for ECMS, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.8)

# Enable Hot Reload for MSVC compilers if supported.
if (POLICY CMP0141)
  cmake_policy(SET CMP0141 NEW)
  set(CMAKE_MSVC_DEBUG_INFORMATION_FORMAT "$<IF:$<AND:$<C_COMPILER_ID:MSVC>,$<CXX_COMPILER_ID:MSVC>>,$<$<CONFIG:Debug,RelWithDebInfo>:EditAndContinue>,$<$<CONFIG:Debug,RelWithDebInfo>:ProgramDatabase>>")
endif()

project ("ECMS")

include(E:/Electro/vcpkg/scripts/buildsystems/vcpkg.cmake)

find_package(FLTK REQUIRED CONFIG)

# Add source to this project's executable.
add_executable (ECMS "ECMS.cpp" "ECMS.h" "Window.h" "Window.cpp" "Mixer.h" "Channel.h" "Channel.cpp" "Mixer.cpp")

link_directories(${VCPKG_INSTALLED_DIR}/x64-windows/lib)
target_link_libraries(ECMS PRIVATE fltk fltk_gl fltk_forms fltk_images)

if (CMAKE_VERSION VERSION_GREATER 3.12)
  set_property(TARGET ECMS PROPERTY CXX_STANDARD 20)
endif()

# TODO: Add tests and install targets if needed.