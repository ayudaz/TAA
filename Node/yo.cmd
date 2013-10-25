@IF EXIST "%~dp0\node.exe" (
  "%~dp0\node.exe"  "%~dp0\node_modules\yo\bin\yo" %*
) ELSE (
  node  "%~dp0\node_modules\yo\bin\yo" %*
)