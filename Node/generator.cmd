@IF EXIST "%~dp0\node.exe" (
  "%~dp0\node.exe"  "%~dp0\node_modules\generator\bin\index.js" %*
) ELSE (
  node  "%~dp0\node_modules\generator\bin\index.js" %*
)