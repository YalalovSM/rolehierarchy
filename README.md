# rolehierarchy
Role hierarchy multiple trees implementation

In Spring Framework 5.0 we had to use next lines:

~~~
security:
  role:
    hierarchy: client-admin > client-delete client-delete > client-create client-create > client-write client-write > client-read admin > delete delete > create create > write write > read
~~~

In Spring Framework 5.1 an internal algo has been changed and we have to use multiple line format

~~~
security:
  role:
    hierarchy: |
      client-admin > client-delete > client-create > client-write > client-read
      admin > delete > create > write > read
~~~
