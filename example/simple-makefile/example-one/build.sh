#!/bin/bash

export LD_LIBRARY_PATH=$(pwd)/sub:$LD_LIBRARY_PATH
echo ${LD_LIBRARY_PATH}

make
./demo
