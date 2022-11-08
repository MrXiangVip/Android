CC ?= gcc
CXX ?= g++
RM = rm -f
STRIP ?= strip
AR ?= ar
CP ?= cp

SUB_LIBNAME = libsub

SHARED = so
STATIC = a

SUB_SHARED = $(SUB_LIBNAME).$(SHARED)
SUB_STATIC = $(SUB_LIBNAME).$(STATIC)

CFLAGS = -fPIC -I../include
SRCS += sub2.c
SRCS += sub3.c

# Sets the output filename and object files
OBJS= $(SRCS:.c=.o)
DEPS= $(OBJS:.o=.d)
-include $(DEPS)


all: shared static

shared: $(SUB_SHARED)

static: $(SUB_STATIC)

$(SUB_SHARED): $(OBJS)
	$(CC) $(CFLAGS) --shared -o $@ $(OBJS)
	@echo "build $(SUB_SHARED)"
	#$(STRIP) $@

$(SUB_STATIC): $(OBJS)
	$(AR) rv $(SUB_STATIC) $?
	@echo "build $(SUB_STATIC)"
	#$(STRIP) $@

%.o: %.c
	$(CC) -c $(CFLAGS) -o $@ $<
	$(CC) -MM $(CFLAGS) $< > $@.d

clean:
	@echo "Cleaning up directory."
	$(RM) $(OBJS) $(SUB_SHARED) $(SUB_STATIC) $(DEPS)
