for file in /usr/include/FL/*.h; do
    cp -- "$file" "${file%.h}.H"
done
