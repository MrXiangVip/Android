CC ?= gcc
CXX ?= g++
RM = rm -f
STRIP ?= strip


DEMO = demo

DEMO_SRCS += main.c
DEMO_SRCS += sub.c


# LIB_SUB = -L./sub -lsub -I./include
# LIBS = -lpthread  -L./sub -lsub -I./include
LIBPATH = -L./sub
INCLUDE = -I./include
LIBS = -lsub

DEMO_OBJS= $(DEMO_SRCS:.c=.o)
DEMO_DEPS= $(DEMO_OBJS:.o=.d)
-include $(DEPS)


all: libsub  $(DEMO)

$(DEMO): $(DEMO_OBJS)
	$(CC)  -o $@ $(DEMO_OBJS) $(LIBPATH) $(LIBS)
# 	$(CC)  -o $@ $(DEMO_OBJS) $(LIBS)
	#$(STRIP) $@

%.o: %.c
	$(CC) -c $(CFLAGS) -o $@ $<
	$(CC) -MM $(CFLAGS) $< > $@.d	

libsub:
	make -C ./sub

.PHONY: clean
clean:
	@echo "Cleaning up directory."
	$(RM) $(DEMO_OBJS) $(DEMO_DEPS) $(DEMO)
	make -C ./sub clean

	
