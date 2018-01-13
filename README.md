# Cabina-Telegram
Repositorio de la cabina de telegram que contendrá todo el código y documentación necesarios.

Enlace a la wiki de la Cabina de Telegram: https://1984.lsi.us.es/wiki-egc/index.php/Cabina_de_telegram_-_17_18_-_G2

**Formato de los commits, especificado según el equipo de Integración:**
- Título del commit: fix: redirección errónea tras emitir voto
- Cuerpo del commit: Después de que el usuario emitiese su voto este era redireccionado a una URL no existente. Ahora el usuario es redireccionado al panel principal.
- Pie del commit: Closes #<número de la incidencia en GitHub>

## Funciones Implementadas

### /login
Permite a un usuario acceder al sistema. Pide un nombre de usuario y, una vez introducido, una contraseña. 

### /votacionesAbiertas
Permite ver una lista de votaciones disponibles.

### /votar
Pedirá al usuario una id para comenzar a votar en la votación con dicha id. Si la votación tiene varias preguntas estas irán apareciendo una a una según sean respondidas.

### /exit
Con este comando, cerraremos nuestra sesión actual, para que no quede abierta para siempre en nuestro dispositivo.
