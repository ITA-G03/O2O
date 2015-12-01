# HRC Windows Development Environment Setup Guide



---
## Software Installation
> Assert you've installed Node.js,MongoDB.Below is the version required.
> Node.js Version >= 0.12 (Mine is v4.2.2 and NPM Version is 3.5.0)
> MongoDB Version >= 3.0 (Mine is v3.0.5)

### Pull Git Repository in "Windows-Branch"
Check out git repository at:
```
git://testdsmw716-w7v/cid
```
in Branch : **Windows-Branch**

> The branch is based on Branch `devint-HRC`.
> Below is the change:(For easier to understand Project Structure and suitable for Windows Development)
> *  Remove Useless Folder `meanjs` and `NODE_TJS`
> *  Update some versions in `package.json` which I meet build error and it work after updated.


### Redis for Windows
1. Download Redis for Windows
You can download at:
[Github Offical Download](https://raw.github.com/ServiceStack/redis-windows/master/downloads/redis64-latest.zip)
or my machine:
[\\CUIJA-W7\Server\Redis2.8](\\CUIJA-W7\Server\Redis2.8)


### Node lib: node-oracle for Windows
1. Download and Install VS Express to build the oracle.node
> That's because when run `npm install` will call `node-gyp rebuild` to build oracle cpp source files .
> And `node-gyp` depends on `MSBuild.exe` which need to install Visual Studio (VS2013 + is recommend)

You can copy VS2013 Express from:
online installation: [\\CUIJA-W7\Installations\wdexpress_full.exe](\\CUIJA-W7\Installations)
offline iso: [\\CUIJA-W7\Installations\vs2013.4_dskexp_ENU.iso](\\CUIJA-W7\Installations)

> **If you don't want to install VS2013**
> You can try this way:
> copy my node_modules files [\\CUIJA-W7\Installations\node_modules\oracledb](\\CUIJA-W7\Installations) into `NJS_DOM_CIS\node_modules`
> when running `npm install`,npm will escape the exist dependency.



2. Download Oracle Client Instant
> For IRIS4 Dev Environment and Default Oracle Client, we mostly using Client in version 11.1.0.6.0 .
> But `node-oracledb` in Windows is not supported version <= 11.2
> So I've updated my Client-Instant into version 11.2.0.2.0

You can download `Oracle ClientInstant & SDK` at
[Oracle Official Site](http://www.oracle.com/technetwork/topics/winx64soft-089540.html)
or my machine:
[\\CUIJA-W7\Installations](\\CUIJA-W7\Installations)

copy [instantclient-basic-windows.x64-11.2.0.2.0.zip]
and [instantclient-sdk-windows.x64-11.2.0.2.0.zip],
extract into any folder you want. (But please remember the path you save it)


3. Installed Python 2.7
Download Python 2.7 at offical site and install
[Python 2.7.10 Download](https://www.python.org/downloads/release/python-2710/)



4. Set Environment Variable
Before setting environment variable,please list the path we have download and extract.
Below is my local setting for example:

* Python.exe file location : `C:\Python`
* My Oracle DB Client installed at: `D:\app\CUIJA\product\11.1.0\client_1` (Assert you installed it before)
* Extract `instantclient-basic-windows.x64-11.2.0.2.0.zip` at `C:\Oracle\instantclient`
* Extract `instantclient-sdk-windows.x64-11.2.0.2.0.zip` at `C:\Oracle\instantclient\sdk`


Then set Global Environment Variables (Please replace path to yours)
Set `OCI_INC_DIR`:`C:\Oracle\instantclient\sdk\include`
Set `OCI_LIB_DIR`:`C:\Oracle\instantclient\sdk\lib\msvc`
Set `PYTHON`:`C:\Python\python.exe`

Add `D:\app\CUIJA\product\11.1.0\client_1\bin;` into `Path`


> Reference Link: [Node-oracledb Installation on Windows](https://github.com/oracle/node-oracledb/blob/master/INSTALL.md#instwin)


## Update NPM package in HRC
> For this part,Branch Windows have update file `package.json`.
> But I want to note it if some error happen caused by version updated.

### NJS_DOM_CIS
1. Remove `bower` in `package.json`
> Cause bower is a client command by npm ,please run
> ``` npm install -g bower ```
> before.

2. Remove `npm-shrinkwrap.json`
> Cause `npm-shrinkwrap.json` will be a config for npm to load dependencies.


3. Update `mssql` version `2.1.6` => `2.3.2`
4. Update `oracledb` version `0.6.0` => `1.4.0`



## Run Application for local development
1. Start MongoDB
Run `mongod.exe` in MongoDB installation folder.
2. Start Redis
Run `redis-server.exe` in Redis2.8 for Windows installation folder.
> Please noted that, you should keep enough memory before you start redis server.
3. Install node package
Run below command in Project folder


```
cd NODE_CID
npm install
```

```
cd NODE_EMAIL
npm install
```

```
cd NJS_DOM_CIS
npm install
```

4. Run Application
Start DOM:
```
cd NJS_DOM_CIS
node server.js
```
Start CIS(PRS):
```
cd NODE_CID
node aiocsu-server-hrc.js
```


Please check in
[HRC-Login Page](http://localhost:3000/HRC/AIOCSU/index.html#/Login)
at `http://localhost:3000/HRC/AIOCSU/index.html#/Login`

If can see login page,means local environment setup mostly no problem.
