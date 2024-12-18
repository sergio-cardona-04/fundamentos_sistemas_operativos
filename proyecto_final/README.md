# Proyecto Final

## Sistemas de Archivos
 
### **Ejercicio 1: Concepto y noción de archivo real y virtual**

**Define el concepto de archivo real y archivo virtual.**

Es el que es considerado como un objeto; está formado por programas, datos o cualquier tipo de información que contenga uno o varios elementos dentro del sistema operativo. Un archivo real se muestra por el espacio que ocupa dentro de un disco duro o el mismo sistema de almacenamiento de archivos administrado por el sistema operativo. 

Es decir, se considera cualquier archivo que ocupe un espacio en una computadora y que se coloque ahí o que el mismo sistema lo haya hecho, sin importar si ocupa poco o mucho espacio. Puede ser colocado en cualquier parte del disco duro o directorio que se desee. 

![ar](archivo_real.png)

Archivo virtual: Es un archivo de uso temporal que es utilizado por los procesos del sistema mientras se están ejecutando dichos procesos. Estos archivos se crean durante la ejecución de un sistema y los utiliza para el almacenamiento de información, intercambio y organización mientras se ejecuta el sistema, su tamaño es muy variable y terminan al detener la ejecución del sistema, muchos de ellos son borrados, por ejemplo, los archivos `.tmp`

Un archivo virtual no tiene una representación física directa en un dispositivo de almacenamiento. En lugar de eso, es una abstracción gestionada por el sistema operativo o alguna aplicación que simula la existencia de un archivo. Los archivos virtuales son utilizados principalmente en contextos como sistemas de archivos virtuales, bases de datos o configuraciones del sistema operativo. El archivo virtual puede ser una representación de los datos que se encuentran en diferentes ubicaciones o incluso en memoria.

![av](av.png)

**Proporciona ejemplos de cómo los sistemas operativos manejan archivos reales y virtuales.**

En Windows, cuando se abre un archivo de texto y se manipula, el sistema de manera interna crea una copia y coloca el símbolo ~ al principio del mismo para distinguir que es temporal, y que es el archivo que está sufriendo las modificaciones mientras no se realice el proceso de guardado del archivo real

Otro ejemplo de archivos temporales son los archivos `.tmp` Los archivos TMP o archivos temporales son generados por los programas o el sistema operativo del ordenador, pero solo existen durante el tiempo que sean necesarios. Una vez se ha cerrado el programa o se ha apagado el ordenador, en general se eliminan todos los archivos TMP utilizados. Este tipo de archivos puede reconocerse por la extensión .tmp.

Si, por ejemplo, abres un documento de Word y escribes algo en él, se creará un archivo temporal en el que se guardará tu texto de forma provisional. Este proceso, sin embargo, no es visible para el usuario, que por el momento no necesita saber de esta copia de seguridad. Al guardar luego los cambios manualmente en el procesador y cerrar el programa, el archivo temporal deja de ser necesario y se elimina.

**Explica un caso práctico donde un archivo virtual sea más útil que un archivo real.**

Un ejemplo puede ser en la utilización de máquinas virtuales, ya que pueden usar discos duros virtuales para almacenar sus sus datos, Estos archivos virtuales representan los discos duros completos de las máquinas virtuales y pueden ser fácilmente movidos o copiados entre diferentes sistemas físicos sin necesidad de tener una correspondencia directa con los dispositivos de almacenamiento reales.
 
### **Ejercicio 2: Componentes de un sistema de archivos**

**Identifica los componentes clave de un sistema de archivos (por ejemplo, metadatos, tablas de asignación, etc.).**

![sa](sa.png)

Un sistema de archivos es el sistema de almacenamiento de un dispositivo de memoria, que estructura y organiza la escritura, búsqueda, lectura, almacenamiento, edición y eliminación de archivos de una manera concreta. El objetivo principal de esta organización es que el usuario pueda identificar los archivos sin lugar a error y acceder a ellos lo más rápido posible. Los sistemas de archivos también otorgan a los archivos, entre otras, las siguientes características:

* Convenciones para nombrar a los archivos
* Atributos de archivo
* Control(es) de acceso

Asimismo, los sistemas de archivos son un componente operativo importante, ya que actúan como una interfaz entre el sistema operativo y todos los dispositivos conectados al equipo (internos y externos, como las memorias USB).

Componentes clave de un sistema de archivos:

* Metadatos: En términos generales, los metadatos son "datos sobre los datos". Proporcionan información crucial acerca de los archivos almacenados en el sistema, como su tamaño, fecha de creación, fecha de última modificación, permisos de acceso, propietario, tipo de archivo, y ubicación física. Los metadatos no contienen la información principal del archivo (como el texto o los datos de una imagen), pero son esenciales para el funcionamiento del sistema de archivos.
    
    Los metadatos desempeñan varias funciones clave en la gestión de archivos:

    * Identificación: Permiten identificar y acceder a un archivo sin necesidad de revisar su contenido. Almacenan el nombre del archivo, el tipo de archivo y la ubicación en el sistema de almacenamiento.
    * Gestión de espacio: Los metadatos son fundamentales para gestionar el espacio de almacenamiento. Permiten conocer qué bloques de almacenamiento están ocupados y cuáles están libres.
    * Seguridad y permisos: Los metadatos incluyen información sobre los permisos de acceso, lo que garantiza que solo los usuarios autorizados puedan leer, escribir o modificar un archivo.
    * Integridad: Pueden incluir sumas de comprobación o huellas digitales que ayudan a verificar la integridad del archivo y a detectar si ha sido alterado.
    * Eficiencia en la búsqueda: Los metadatos hacen que la búsqueda y la organización de archivos sean mucho más rápidas, ya que permiten al sistema de archivos acceder directamente a los detalles de los archivos sin tener que revisar su contenido.
* Inodos (en sistemas de archivos como ext4): Un inodo es una estructura de datos que almacena información sobre un archivo o directorio en sistemas de archivos como ext4. Cada archivo tiene un inodo asociado que contiene los metadatos sobre el archivo (excepto su nombre y su contenido). Los inodos incluyen:
    * El tipo de archivo (archivo regular, directorio, enlace simbólico, etc.)
    * El propietario y los permisos de acceso
    * Las direcciones de los bloques de datos que componen el archivo.
* Tablas de asignación: Las tablas de asignación son estructuras utilizadas por el sistema de archivos para llevar un registro de qué bloques de almacenamiento están ocupados y cuáles están libres. En sistemas de archivos como FAT (File Allocation Table) o NTFS (New Technology File System), las tablas de asignación gestionan la ubicación física de los archivos en el dispositivo de almacenamiento.
    * FAT: La tabla de asignación (FAT) contiene una lista de los clusters (bloques de almacenamiento) que pertenecen a un archivo.
    * NTFS: Utiliza una tabla llamada MFT (Master File Table) que contiene información detallada sobre cada archivo, incluyendo sus ubicaciones en el disco.
* Directores o Directorios: Un directorio (o carpeta) es una estructura fundamental en cualquier sistema de archivos, diseñada para organizar y agrupar archivos de forma jerárquica. Los directorios permiten que los usuarios y el sistema operativo gestionen grandes cantidades de archivos de manera ordenada, facilitando el acceso, la modificación y la administración de los datos almacenados. En este contexto, un directorio puede considerarse como un contenedor o una "caja" que almacena archivos o subdirectorios (directorios dentro de otros directorios). Cada sistema de archivos maneja los directorios de manera diferente, pero los conceptos básicos son generalmente los mismos en la mayoría de los sistemas.

    El principal propósito de un directorio es proporcionar una manera estructurada de organizar los archivos. Sin un sistema de directorios, todos los archivos se almacenarían en un único espacio plano, lo que haría extremadamente difícil encontrar y gestionar los archivos de manera eficiente. Los directorios permiten una organización jerárquica (estructura en árbol) en la que un directorio principal o raíz contiene otros subdirectorios, y estos pueden contener más subdirectorios, creando una estructura en niveles.

    En términos prácticos, los directorios cumplen con varias funciones clave:

    * Organización: Agrupan archivos relacionados, lo que facilita la localización y administración de los mismos.
    * Seguridad y Control de Acceso: Los directorios permiten definir permisos de acceso, asegurando que solo los usuarios o grupos autorizados puedan ver o modificar ciertos archivos o directorios.
    * Gestión de Espacio: Facilitan la gestión del espacio de almacenamiento, ayudando a localizar los archivos en el sistema de manera eficiente.

* Bloques de datos: Un bloque de datos es la unidad más pequeña de almacenamiento que el sistema de archivos puede manejar. Cuando un archivo se guarda en el sistema, se divide en bloques que pueden estar dispersos a lo largo del disco. Estos bloques son las "piezas" físicas que ocupan espacio en el dispositivo de almacenamiento. Los bloques se agrupan en sectors (sectores) y su tamaño varía dependiendo del sistema de archivos y la configuración del dispositivo de almacenamiento.

    En muchos sistemas operativos modernos, el tamaño de los bloques suele ser de 4 KB, aunque se puede configurar el tamaño dependiendo de la implementación del sistema de archivos y las necesidades del usuario. Algunos sistemas permiten tamaños de bloque más pequeños o más grandes, como 512 bytes o hasta 64 KB, en función del tipo de datos que se almacenen. Los bloques más grandes permiten almacenar archivos grandes de manera más eficiente, pero pueden llevar a una mayor fragmentación si los archivos son pequeños.

    La gestión de los bloques de datos es esencial para la eficiencia del sistema de archivos. Los sistemas de archivos modernos emplean diferentes técnicas para manejar y organizar estos bloques, las cuales incluyen:

    1. Asignación de Bloques: Cuando un archivo se guarda, el sistema de archivos asigna bloques de datos de forma continua o dispersa, dependiendo de su capacidad y del método de asignación utilizado. Los bloques asignados se mantienen en una estructura de datos (como una tabla de asignación, inodo, o MFT) que permite al sistema operativo localizar y acceder a los bloques cuando sea necesario.
        * Asignación contigua: En este enfoque, los bloques de datos de un archivo se almacenan de manera continua en el disco. Es eficiente en términos de acceso rápido a los datos, pero puede llevar a la fragmentación cuando se eliminan archivos y se rellenan huecos.
        * Asignación no contigua: En este caso, los bloques de un archivo pueden estar dispersos por todo el disco. Aunque esto puede aumentar la fragmentación, es más flexible y eficiente en términos de uso del espacio disponible en el disco.
    2.Fragmentación: La fragmentación ocurre cuando los bloques de datos de un archivo se distribuyen en diferentes ubicaciones del disco en lugar de estar almacenados de manera contigua. La fragmentación puede afectar negativamente el rendimiento, ya que el sistema debe buscar y acceder a múltiples ubicaciones para leer o escribir un archivo.

        Los sistemas de archivos modernos, como EXT4 y NTFS, incluyen algoritmos de desfragmentación o de optimización que intentan minimizar la fragmentación o gestionarla de manera eficiente. Por ejemplo, en EXT4, los archivos se almacenan preferentemente en bloques contiguos, aunque si no hay suficiente espacio, se dispersan.

    3. Bloques y Subbloques: En algunos sistemas de archivos avanzados, como ZFS o XFS, los bloques de datos pueden dividirse en subbloques para mejorar la granularidad del almacenamiento. Esto permite un acceso más eficiente y una mejor gestión del espacio, especialmente cuando los archivos son muy pequeños.

    4. Bloques y Seguridad: Algunos sistemas de archivos implementan técnicas de verificación de integridad que aseguran que los bloques de datos no se corrompan. En ZFS, por ejemplo, los bloques de datos están protegidos por sumas de comprobación (checksums) para detectar errores o corrupción.

* Tabla de archivos libres: Las tablas de archivos libres son estructuras de datos que contienen información sobre los bloques o clústeres disponibles para almacenar archivos y datos. Los sistemas de archivos gestionan el espacio en disco dividiéndolo en unidades llamadas bloques o clústeres. Cada vez que un archivo se guarda en el disco, se asignan uno o más de estos bloques. Sin embargo, no todos los bloques del disco están siendo utilizados constantemente; algunos pueden estar libres, es decir, disponibles para almacenar nuevos archivos.

    Las tablas de archivos libres permiten al sistema operativo mantener un registro actualizado de estos bloques libres, asegurando que los bloques ocupados no se asignen de nuevo accidentalmente y ayudando a evitar la fragmentación excesiva.

    El funcionamiento de la tabla de archivos libres se basa en dos tareas principales: asignación y liberación de bloques.
    * Asignación de bloques: Cuando un archivo se guarda en el disco, el sistema operativo consulta la tabla de archivos libres para encontrar bloques disponibles. El sistema asigna uno o más bloques consecutivos al archivo y actualiza la tabla de archivos libres para marcar esos bloques como ocupados. Este proceso puede ser más complejo si el sistema de archivos tiene que buscar varios bloques libres consecutivos (para evitar la fragmentación) o si los bloques están dispersos por todo el disco.
    * Liberación de bloques: Cuando un archivo se elimina o se modifica, el sistema operativo libera los bloques de almacenamiento que ya no son necesarios. Estos bloques se vuelven disponibles para ser reutilizados, y la tabla de archivos libres se actualiza en consecuencia. En sistemas avanzados, la liberación de bloques también puede implicar la consolidación de bloques libres consecutivos para mejorar la eficiencia del almacenamiento.

    Una de las principales funciones de las tablas de archivos libres es minimizar la fragmentación en el disco. La fragmentación ocurre cuando los bloques de un archivo no están contiguos, lo que provoca un acceso más lento al archivo. Existen dos tipos principales de fragmentación: fragmentación interna que es cuando se asignan bloques de tamaño fijo y un archivo no utiliza todo el espacio de un bloque. En estos casos, los bloques pueden quedar parcialmente vacíos, desperdiciando espacio; y la fragmentación externala cual ocurre cuando los bloques de un archivo se distribuyen de manera no contigua en el disco, lo que provoca que la lectura del archivo sea más lenta.

    Las tablas de archivos libres ayudan a mitigar la fragmentación, ya que permiten al sistema operativo localizar bloques libres de manera eficiente y asignarlos de forma que minimice la fragmentación, asignando bloques contiguos siempre que sea posible.

* Árboles B+ (en sistemas como NTFS): En sistemas de archivos más avanzados como NTFS, los archivos y directorios se organizan mediante estructuras llamadas árboles B+. Estos árboles permiten un acceso eficiente a grandes volúmenes de datos, especialmente cuando se trata de índices de archivos y directorios.

**Crea un cuadro comparativo de cómo estos componentes funcionan en sistemas como EXT4 y NTFS.**

| Componente        |   EXT4            |   NTFS                |
|-------------------|-------------------|-----------------------|
|Metadatos|En EXT4, los metadatos se almacenan en inodos, que contienen información como permisos, tamaño, propietario y ubicación del archivo.|NTFS también usa un mecanismo similar con la MFT (Master File Table), que contiene metadatos sobre los archivos, como tamaño, atributos, ubicación, y permisos.|
|Inodos| Los inodos son fundamentales en EXT4. Cada archivo tiene un inodo que contiene metadatos y punteros a los bloques de datos del archivo. | NTFS no utiliza inodos de manera explícita. En su lugar, usa la MFT que realiza una función similar. Cada archivo tiene una entrada en la MFT que contiene metadatos. |
|Tablas de Asignación| EXT4 no utiliza una tabla de asignación tradicional como FAT. Usa una estructura de bloques y un mapa de bits para rastrear bloques libres y ocupados. | NTFS utiliza la MFT para gestionar la ubicación de los archivos, pero también tiene una tabla de asignación de archivos, lo que le permite gestionar el espacio en disco y las relaciones de archivo. |
|Directorio/Directorios| EXT4 usa un sistema de directorios que puede contener tanto archivos como subdirectorios. Los directorios son implementados como archivos especiales en el sistema. | En NTFS, los directorios son también archivos especiales que contienen información sobre el archivo y sus subdirectorios.|
|Bloques de Datos| EXT4 divide los archivos en bloques, que son unidades de almacenamiento de tamaño fijo (generalmente 4KB, aunque puede configurarse). Cada archivo se almacena en uno o más bloques.| NTFS también divide los archivos en bloques de datos llamados "clusters", que son unidades de almacenamiento de tamaño variable (generalmente 4KB, pero el tamaño puede variar).| 
|Tabla de Archivos Libres| EXT4 usa un mapa de bits para gestionar los bloques libres en el sistema de archivos. Cada bit representa un bloque y está marcado como libre o ocupado. | NTFS tiene un registro de clústeres libres que rastrea los bloques libres. Sin embargo, también usa la MFT para gestionar los archivos y su espacio de almacenamiento. |
|Árboles B+| EXT4 utiliza estructuras de tipo árbol B+ para la organización de directorios, lo que facilita una búsqueda eficiente. | NTFS usa árboles B+ para la organización de archivos, directorios y metadatos en la MFT, permitiendo una búsqueda rápida y eficiente, especialmente en sistemas con grandes volúmenes de datos.


**Describe las ventajas y desventajas de cada sistema basado en sus componentes.**

Ventajas de EXT4

* Sistema de archivos grande: El sistema de archivos ext4 puede soportar volúmenes con tamaños en teoría hasta 64 zebibyte (ZiB) y archivos individuales con tamaños de hasta 16 tebibytes (TiB) con el tamaño estándar de bloque 4 KiB, y volúmenes con tamaños de hasta 1 yobibyte (YiB) con 64 racimos KiB, aunque una limitación en el formato de extensión hace 1 exbibyte (EiB) el límite práctico. Los límites máximos del archivo, directorio y tamaño del sistema de archivos crecen al menos proporcionalmente con el tamaño del bloque del sistema de archivos hasta el tamaño máximo de bloque de 64 KiB disponible en las CPUs ARM y PowerPC/Power ISA.
* Extents: Las patentes reemplazan el esquema tradicional de mapeo de bloques utilizado por ext2 y ext3. Una extensión es una gama de bloques físicos contiguos, mejorando el rendimiento de gran formato y reduciendo la fragmentación. Una sola extensión en ext4 puede mapear hasta 128 MiB de espacio contiguo con un tamaño de bloque 4 KiB. Puede haber cuatro extensiones almacenadas directamente en el interior. Cuando hay más de cuatro extensiones en un archivo, el resto de las extensiones se indexan en un árbol.
* Compatibilidad de retroceso: ext4 es compatible con ext3 y ext2, lo que permite montar ext3 y ext2 como ext4. Esto mejorará ligeramente el rendimiento, ya que algunas nuevas características de la aplicación ext4 también se pueden utilizar con ext3 y ext2, como el nuevo algoritmo de asignación de bloques, sin afectar el formato on-disk.
    
    ext3 es parcialmente compatible con el ext4. Prácticamente, ext4 no montará como un ext3 sistema de archivos fuera de la caja, a menos que ciertas características nuevas estén deshabilitadas al crearlo, como ^extent, ^flex_bg, ^huge_file, ^uninit_bg, ^dir_nlink, y ^extra_isize.

* Ubicación previa persistente: ext4 puede pre-allocalizar espacio en disco para un archivo. Para ello en la mayoría de los sistemas de archivos, ceros se escribirían al archivo cuando se creó. En ext4 (y algunos otros sistemas de archivos como XFS) fallocate(), se puede utilizar una nueva llamada del sistema en el núcleo Linux. El espacio asignado estaría garantizado y probablemente contiguo. Esta situación tiene aplicaciones para la transmisión de medios y bases de datos.
* Asignación tardía: ext4 utiliza una técnica de rendimiento llamada asignar-on-flush, también conocida como demora en la asignación. Es decir, los retrasos ext4 bloquean la asignación hasta que los datos se filtran al disco; en cambio, algunos sistemas de archivos asignan bloques inmediatamente, incluso cuando los datos entran en un caché de escritura. La asignación retrasada mejora el rendimiento y reduce la fragmentación asignando efectivamente cantidades mayores de datos a la vez.
* Número ilimitado de subdirectorios: ext4 no limita el número de subdirectorios en un solo directorio, excepto por el límite de tamaño inherente del propio directorio. (En ext3 un directorio puede tener en la mayoría de 32.000 subdirectorios.) Para permitir directorios más grandes y un rendimiento continuo, ext4 en Linux 2.6.23 y luego se activan índices HTree (una versión especializada de un árbol B) por defecto, lo que permite que los directorios de hasta 10-12 millones de entradas se almacenen en el índice HTree de 2 niveles y límite de tamaño de directorio 2 GB para el tamaño de bloque 4 KiB, dependiendo de la longitud del nombre de archivo. En Linux 4.12 y más tarde large_dir característica habilitada un HTree de 3 niveles y tamaños de directorios de más de 2 GB, permitiendo aproximadamente 6 billones de entradas en un solo directorio.
* Cuestionario: ext4 utiliza checksums en la revista para mejorar la fiabilidad, ya que la revista es uno de los archivos más utilizados del disco. Esta característica tiene un beneficio secundario: puede evitar con seguridad un disco I/O esperar durante la publicación, mejorando el rendimiento ligeramente. Se inspiró en un artículo de investigación de la Universidad de Wisconsin, titulado Sistemas de archivos IRON, con modificaciones dentro de la implementación de transacciones compuestas realizadas por el sistema de archivos IRON (originalmente propuesto por Sam Naghshineh en la cumbre de RedHat).
* Comprobación de metadatos; Desde Linux kernel 3.5 lanzado en 2012.
* Verificación del sistema de archivos más rápido: En ext4 grupos de bloques no identificados y secciones de la tabla de inodo están marcados como tales. Esto permite que e2fsck salte por completo y reduce enormemente el tiempo necesario para comprobar el sistema de archivos. Linux 2.6.24 implementa esta función.
* Multiblock allocator: Cuando ext3 anexa a un archivo, llama al aleator de bloque, una vez por cada bloque. En consecuencia, si hay varios escritores concurrentes, los archivos se pueden fragmentar fácilmente en el disco. Sin embargo, ext4 utiliza la asignación retardada, lo que le permite amortiguar datos y asignar grupos de bloques. En consecuencia, el aleator multibloque puede tomar mejores opciones sobre la asignación de archivos de forma contigua en el disco. El aleator multibloque también se puede utilizar cuando los archivos se abren en modo O_DIRECT. Esta función no afecta el formato de disco.
* Gráficos mejorados: A medida que las computadoras se vuelven más rápidas en general, y a medida que Linux se utiliza más para aplicaciones críticas de la misión, la granularidad de los tiempos de segunda base se vuelve insuficiente. Para resolver esto, ext4 proporciona temporizadores medidos en nanosegundos. Además, 2 bits del campo de timetamp expandido se añaden a los bits más significativos del campo de segundos de los timetamps para aplazar el problema del año 2038 por un adicional de 408 años.
    ext4 también añade soporte para time-of-creation timestamps. Pero, como señala Theodore Ts'o, mientras que es fácil añadir un campo de creación-fecha extra en el inodo (porque el soporte técnico para estos timetamps en ext4), es más difícil modificar o añadir las llamadas necesarias del sistema, como stat() (que probablemente requeriría una nueva versión) y las diversas bibliotecas que dependen de ellos (como glibc). Estos cambios requerirán la coordinación de muchos proyectos. Por lo tanto, la fecha de creación almacenada por ext4 solo está disponible actualmente para programas de usuario en Linux a través de la statx() API.
* cupos de proyectos: El soporte para cuotas de proyecto se agregó en Linux kernel 4.4 el 8 de enero de 2016. Esta característica permite asignar límites de cuota de disco a un ID de proyecto particular. El ID de proyecto de un archivo es un número de 32 bits almacenado en cada archivo y es heredado por todos los archivos y subdirectorios creados bajo un directorio padre con un ID de proyecto asignado. Esto permite asignar límites de cuota a un árbol de subdirectorio particular independiente de permisos de acceso a archivos en el archivo, tales como cuotas de usuario y proyecto que dependen de la UID y GID. Si bien esto es similar a una cuota de directorio, la diferencia principal es que el mismo ID de proyecto se puede asignar a múltiples directorios de nivel superior y no es estrictamente jerárquico.
* Cifrado transparente: El soporte para encriptación transparente se agregó en Linux kernel 4.1 en junio de 2015.

![extd4](extd4.png)

Limitaciones de EXT4

* En 2008, el principal desarrollador de los sistemas de archivos ext3 y ext4, Theodore Ts'o, afirmó que, aunque ext4 ha mejorado sus características, no se trata de un gran avance, ya que utiliza tecnología antigua y es una solución provisional. Ts'o cree que Btrfs es la mejor opción porque "ofrece mejoras en escalabilidad, fiabilidad y facilidad de gestión". Btrfs también tiene "varias de las mismas ideas de diseño que reiser3/4". Sin embargo, ext4 ha seguido incorporando nuevas características, como cifrado de archivos y sumas de comprobación de metadatos.
* El sistema de archivos ext4 no respeta el atributo de archivo "eliminación segura", que se supone que provoca la sobrescritura de los archivos al eliminarlos. En 2011 se propuso un parche para implementar la eliminación segura, pero no resolvió el problema de los datos confidenciales que terminaban en el diario del sistema de archivos.

Ventajas de NTFS

1. Seguridad y Permisos: NTFS permite asignar permisos específicos a archivos y carpetas, lo que mejora la seguridad al controlar quién puede acceder y modificar ciertos datos. También es compatible con cifrado de archivos mediante EFS (Encrypting File System).
2. Compatibilidad con Archivos Grandes: A diferencia de FAT32, que tiene un límite de tamaño de archivo de 4 GB, NTFS puede manejar archivos mucho más grandes, lo que es crucial para aplicaciones modernas que manejan grandes volúmenes de datos.
3. Compresión de Archivos: NTFS permite la compresión de archivos y carpetas, lo que puede ahorrar espacio en disco sin necesidad de herramientas adicionales.
4. Recuperación ante Errores: NTFS incluye características de tolerancia a fallos, como el registro de transacciones y la restauración automática, lo que ayuda a mantener la integridad de los datos y facilita la recuperación en caso de fallos del sistema.
5. Cuotas de Disco: NTFS permite a los administradores establecer límites en la cantidad de espacio en disco que puede utilizar cada usuario, lo cual es útil en entornos multiusuario.
6. Soporte de Metadatos: NTFS maneja metadatos avanzados, permitiendo a los usuarios almacenar información adicional sobre los archivos, como fechas de creación, modificación y acceso.

![nt](ntfs4.png)

Inconvenientes de NTFS

1. Compatibilidad Limitada: NTFS está optimizado para sistemas operativos Windows. Aunque Linux y macOS pueden leer NTFS y, en algunos casos, escribir en él, la compatibilidad no es tan nativa ni eficiente como en Windows.
2. Complejidad: Las características avanzadas de NTFS, como los permisos de archivo y la compresión, pueden añadir complejidad a la gestión del sistema de archivos, especialmente para usuarios menos experimentados.
3. Fragmentación: Aunque NTFS maneja la fragmentación de archivos mejor que FAT32, aún puede sufrir de fragmentación, lo que puede ralentizar el rendimiento del disco con el tiempo. Es recomendable desfragmentar los discos NTFS periódicamente.
4. Mayor Uso de Recursos: Las funcionalidades avanzadas de NTFS pueden consumir más recursos del sistema en comparación con sistemas de archivos más simples, lo que puede no ser ideal para dispositivos con recursos limitados.


### **Ejercicio 3: Organización lógica y física de archivos**

**Diseña un árbol jerárquico que represente la organización lógica de directorios y subdirectorios.**

La jerarquía del sistema de archivos es la organización de archivos y directorios en una estructura lógica y jerárquica. Proporciona una forma de organizar archivos y directorios según su propósito y ubicación. Estos son los componentes principales de la jerarquía del sistema de archivos:

![jsa](jsa.png)

* Directorio raíz: el directorio raíz es el directorio de nivel superior en la jerarquía del sistema de archivos. Está representado por una barra diagonal (/) y contiene todos los demás directorios y archivos.
* Subdirectorios: los subdirectorios son directorios que se encuentran dentro de otros directorios. Proporcionan una forma de organizar archivos en grupos lógicos según su propósito o ubicación.
* Rutas de archivos: las rutas de archivos son las rutas que se utilizan para localizar archivos dentro de la jerarquía del sistema de archivos. Consisten en una serie de nombres de directorio separados por barras diagonales que conducen al archivo en sí.
* Montaje del sistema de archivos: el montaje del sistema de archivos es el proceso de hacer que un sistema de archivos esté disponible para su uso. Cuando se monta un sistema de archivos, su directorio raíz se adjunta a un directorio en la jerarquía del sistema de archivos existente, como el directorio raíz.

**Explica cómo se traduce la dirección lógica a la dirección física en el disco.**

**MMU (Unidad de gestión de memoria):**

la asignación de tiempo de ejecución entre la dirección virtual y la dirección física se realiza mediante un dispositivo de hardware conocido como MMU.
En la administración de memoria, el sistema operativo manejará los procesos y moverá los procesos entre el disco y la memoria para su ejecución. Realiza un seguimiento de la memoria disponible y utilizada.

![mmu](mmu.png)

1. La CPU generará una dirección lógica, por ejemplo: 346
2. MMU generará un registro de reubicación (registro base) por ejemplo: 14000
3. En la memoria, se encuentra la dirección física, por ejemplo: (346+14000= 14346)

El valor en el registro de reubicación se agrega a cada dirección generada por un proceso de usuario en el momento en que la dirección se envía a la memoria. El programa de usuario nunca ve las direcciones físicas reales. El programa puede crear un puntero a la ubicación 346, almacenarlo en la memoria, manipularlo y compararlo con otras direcciones, todo como el número 346. 
El programa de usuario genera solo direcciones lógicas. Sin embargo, estas direcciones lógicas deben asignarse a direcciones físicas antes de que se utilicen. 

**Proporciona un ejemplo práctico de cómo un archivo se almacena físicamente.**

Supongamos que se crea un archivo llamado documento.txt con un tamaño de 5 MB:

1. División del archivo en bloques: el sistema operativo divide el archivo en fragmentos más pequeños conocidos como clusters o bloques, dependiendo del tamaño del clúster definido por el sistema de archivos. En NTFS, el tamaño típico de un clúster es de 4 KB; esto significa que documento.txt ocupará aproximadamente 1280 clústeres en el disco.
2. Ubicación física en el disco: NTFS utiliza una tabla llamada MFT (Master File Table) para registrar la ubicación exacta de cada clúster que contiene datos del archivo. En el caso de documento.txt, la MFT almacena:
    * El nombre del archivo.
    * El tamaño del archivo.
    * Las ubicaciones físicas de los clústeres en el disco donde se encuentra el archivo.
3. Escritura de los datos:
    * Los datos de documento.txt se escriben físicamente en sectores del disco duro. Los sectores son las divisiones más pequeñas del almacenamiento físico (típicamente de 512 bytes o 4096 bytes, dependiendo del disco).
    * Cada clúster consiste en varios sectores contiguos.
4. Gestión de fragmentación:
    * Si hay suficiente espacio contiguo disponible en el disco, los 1280 clústeres del archivo se almacenan en sectores contiguos. Sin embargo, si el espacio está fragmentado, los clústeres pueden dividirse y distribuirse en diferentes áreas del disco.
    * La MFT se encarga de rastrear esta distribución para que el sistema operativo pueda reconstruir el archivo cuando sea necesario.
5. Metadatos adicionales:
    * NTFS también almacena metadatos sobre el archivo, como:
        * Fecha de creación, modificación y acceso.
        * Permisos de acceso.
        * Propiedades del archivo.
6. Acceso al archivo:
    * Cuando el usuario abre documento.txt, el sistema operativo consulta la MFT para localizar los clústeres asociados al archivo.
    * Los datos se leen en la memoria RAM desde los sectores correspondientes del disco y se presentan al usuario.
 

### **Ejercicio 4: Mecanismos de acceso a los archivos**

**Define los diferentes mecanismos de acceso.**

Existen varios mecanismos para acceder a los archivos dentro de un sistema operativo, y la elección del mecanismo adecuado depende del tipo de archivo y de las operaciones que se necesiten realizar. Los tres principales mecanismos de acceso a los archivos son:

* **Acceso secuencial:** El acceso secuencial es un método en el que los datos se leen o se escriben en un archivo de manera continua, uno después de otro, siguiendo el orden en el que están almacenados. Este es uno de los métodos más antiguos y simples de acceso a archivos, y es comúnmente utilizado para procesar archivos de datos o registros donde la lectura debe ser lineal, es decir, no se necesita acceder a una parte específica del archivo de manera aleatoria.

    En el acceso secuencial, el puntero de lectura o escritura del archivo se mueve automáticamente hacia adelante mientras lee o escribe datos, y no se puede retroceder ni avanzar a una parte específica del archivo sin pasar por los datos intermedios. Esto significa que se debe procesar todo el archivo, desde el principio hasta el final, en el orden en que está almacenado.

    Pasoso del acceso secuencial.

    1. Abrir el Archivo en Modo Secuencial: El primer paso para realizar un acceso secuencial es abrir el archivo en modo lectura o escritura. Dependiendo de la operación que quieras realizar (lectura o escritura), el sistema operativo configurará el archivo para que puedas interactuar con él.
        * Modo lectura: El archivo se abre para leer su contenido, y el puntero de lectura se coloca en el principio del archivo.
        * Modo escritura: El archivo se abre para escribir en él, comenzando desde el principio (o desde el final, dependiendo del modo de apertura). Si el archivo no existe, el sistema puede crear un nuevo archivo.
    2. Colocar el Puntero en el Comienzo del Archivo: Una vez que el archivo está abierto, el sistema de archivos coloca un puntero de lectura al principio del archivo. Este puntero se mueve automáticamente mientras se leen o escriben los datos secuenciales, y su ubicación marca qué parte del archivo se está procesando en ese momento.
        * Puntero de lectura: Este puntero indica la posición dentro del archivo desde la que se leerán los datos. En el caso de un acceso secuencial, este puntero siempre se mueve hacia adelante, leyendo datos en el orden en que están almacenados.
        * Puntero de escritura: En el caso de escribir, si el archivo ya contiene datos, el puntero de escritura puede colocarse al final del archivo o en cualquier otra posición, dependiendo de la configuración del sistema de archivos y de la operación solicitada.
    3. Leer o Escribir Datos en el Orden Secuencial: El proceso de lectura o escritura en un archivo secuencial es relativamente sencillo: el sistema lee o escribe datos en bloques consecutivos. En sistemas modernos, los archivos están divididos en bloques de datos (generalmente 4 KB, aunque el tamaño puede variar). Estos bloques son la unidad mínima de lectura o escritura en el disco.
    4. Comprobar el Final del Archivo: Uno de los aspectos clave del acceso secuencial es la necesidad de saber cuándo se ha llegado al final del archivo. El sistema de archivos mantiene un indicador de final de archivo (EOF, por sus siglas en inglés) que señala que no hay más datos que leer. Cuando el puntero de lectura alcanza este punto, el proceso de lectura se detiene.
    5. Cerrar el archivo: Después de que se han completado las operaciones de lectura o escritura, es importante cerrar el archivo para liberar los recursos del sistema y garantizar que cualquier cambio realizado en el archivo se guarde correctamente.

* **Acceso directo o aleatorio:** En el acceso directo (también llamado acceso aleatorio), se puede acceder a cualquier parte del archivo sin tener que recorrer los datos de manera secuencial. El sistema de archivos utiliza índices o punteros para ubicar directamente cualquier posición dentro del archivo. Es muy útil para bases de datos o archivos donde los usuarios necesitan acceder a información específica sin leer todo el archivo.

    1. Apertura del archivo y localización inicial:
        * Cuando se abre un archivo para su acceso aleatorio, el sistema operativo o el programa que está utilizando el archivo debe tener una forma de localizar la posición de inicio del archivo. Dependiendo del sistema de archivos y del tipo de almacenamiento, esto puede ser tan simple como posicionar un puntero de archivo en la primera posición del archivo (por ejemplo, al principio del archivo).
        * El sistema operativo establece un puntero o cursor, el cual señala la ubicación actual del archivo. Este puntero puede moverse libremente dentro del archivo para leer o escribir datos desde cualquier punto.
    2. Posicionamiento del puntero en la ubicación deseada:
        * Posición fija: Para acceder aleatoriamente a una parte específica del archivo, primero se debe mover el puntero del archivo a la ubicación deseada. Esto puede hacerse mediante el uso de un número de offset (desplazamiento), que indica el número de bytes desde el comienzo del archivo.
        * El offset se calcula con base en la estructura del archivo. Por ejemplo, si un archivo contiene registros de 100 bytes, y se desea acceder al tercer registro, el desplazamiento será de 200 bytes (100 bytes por registro * 2 registros anteriores). Este desplazamiento se sumará al inicio del archivo para ubicar el puntero en la posición exacta donde comienza el tercer registro.
    3. Lectura o escritura de datos:
        * Una vez que el puntero está posicionado en la ubicación correcta, el sistema puede proceder a leer o escribir datos. Si el archivo está en un formato binario, el sistema de archivos puede leer o escribir bloques de datos de longitud fija, de acuerdo con el tipo de archivo.
        * En este caso, el puntero se desplazará de manera aleatoria a través de diferentes puntos del archivo para acceder a la información específica. Por ejemplo, si se desea leer un registro específico, el sistema accederá directamente a la ubicación correspondiente y procederá con la operación de lectura.
    4. Uso de índices (en sistemas avanzados):
        * Algunos sistemas de archivos y bases de datos utilizan índices para optimizar aún más el acceso aleatorio. En lugar de calcular el desplazamiento manualmente, el sistema puede utilizar un índice que le indique la ubicación precisa del bloque de datos en el archivo.
        * Un índice es una estructura que contiene las ubicaciones (direcciones físicas) de los bloques de datos, lo que permite acceder a los datos de manera más eficiente. Por ejemplo, en un sistema de bases de datos, un índice puede almacenar claves y punteros a registros específicos dentro del archivo, permitiendo que el sistema recupere datos de manera rápida sin tener que buscar secuencialmente.
    5. Actualización de puntero al leer o escribir:
        * Después de realizar una operación de lectura o escritura, el puntero del archivo se mueve automáticamente a la próxima ubicación después de los datos leídos o escritos. Esto permite realizar múltiples operaciones aleatorias sin necesidad de reubicar manualmente el puntero entre operaciones.
        * Por ejemplo, si se lee un bloque de 512 bytes desde la posición 1000 hasta la 1511, el puntero se moverá automáticamente a la posición 1512, y la próxima lectura o escritura se realizará desde allí.
    6. Cierre del archivo:
        * Una vez que se ha terminado de acceder aleatoriamente al archivo, el archivo se cierra. En este paso, el sistema operativo libera cualquier recurso asociado con el archivo, y el puntero se restablece. Cerrar el archivo también asegura que cualquier cambio realizado en el archivo se guarde adecuadamente, dependiendo del modo de apertura (lectura o escritura).
        * Si el archivo estaba en modo de escritura, los cambios realizados se almacenan permanentemente en el disco; si estaba en modo de lectura, no hay cambios, y el archivo permanece igual.

* **Acceso por indice**: El acceso por índice es una técnica que permite localizar rápidamente un archivo o un registro dentro de un archivo mediante una estructura adicional llamada índice. El índice actúa como una tabla de referencia o un mapa que contiene las direcciones de los bloques de datos o registros, lo que facilita la búsqueda directa sin necesidad de recorrer todos los datos. Es especialmente útil en sistemas donde se necesita realizar búsquedas frecuentes y rápidas, como en bases de datos o grandes volúmenes de datos almacenados en archivos.

    El acceso por índice se basa en el uso de una estructura de índice que organiza las claves de búsqueda (como los identificadores de registros o campos clave) y las mapea a las posiciones donde se encuentran los datos correspondientes. Existen varias formas de implementar un índice, pero los más comunes son:

    1. Índice simple: En este tipo de índice, la clave de búsqueda (por ejemplo, un identificador de usuario o una clave primaria) está asociada a una dirección de bloque o posición en el archivo donde se encuentra el dato.
    2. Índice compuesto o multifield: Utiliza múltiples claves de búsqueda (por ejemplo, una combinación de nombre y fecha de nacimiento) para mejorar la precisión en la búsqueda.
    3. Índice de árbol B+: Es una estructura más compleja y eficiente, donde los datos están organizados en una estructura de árbol equilibrado, lo que permite búsquedas rápidas y eficientes.

    A continuación, se detalla cómo funciona el proceso de acceso a un archivo utilizando un índice, paso a paso.

    1. Creación del índice: antes de que cualquier operación de búsqueda pueda realizarse, el archivo debe estar indexado. El proceso de indexación consiste en crear una tabla de índice o una estructura de árbol (como un árbol B+) que asocia las claves de búsqueda con las ubicaciones de los registros en el archivo. El índice se construye en base a un campo o conjunto de campos que se usan para localizar los datos (por ejemplo, una clave primaria en una base de datos).
    2. Búsqueda en el índice: una vez que el índice ha sido construido, el proceso de acceso por índice comienza cuando el usuario o la aplicación realiza una búsqueda. La búsqueda se realiza sobre la tabla de índice, no sobre el archivo original.

        * Búsqueda de clave: El sistema busca la clave que corresponde al dato que se desea encontrar. Dependiendo del tipo de índice, este proceso puede ser muy rápido:
            * En un índice simple, se busca la clave en una lista o una tabla.
            * En un índice de árbol B+, el sistema recorre los nodos del árbol hasta encontrar la clave o el rango de claves que coincide con la búsqueda.
        * Acceso al registro: Una vez encontrada la clave en el índice, la estructura del índice proporciona la dirección o puntero al bloque de datos correspondiente en el archivo.

    3. Acceso al archivo usando el índice: con la dirección proporcionada por el índice, el sistema puede acceder directamente al bloque de datos donde se encuentra el registro o la información solicitada. Este paso es muy rápido porque el índice actúa como un mapa que ha sido optimizado para localizar la información sin necesidad de recorrer secuencialmente el archivo completo.

        * Si estamos utilizando un índice simple, el proceso es directo: el sistema simplemente utiliza la dirección contenida en el índice para ir al bloque exacto donde se encuentra el registro.
        * Si estamos utilizando un índice de árbol B+, el sistema utiliza los punteros almacenados en los nodos del árbol para navegar eficientemente hasta encontrar el bloque correcto.

    4. Lectura del bloque de datos: una vez que el sistema ha localizado el bloque de datos correspondiente, procede a leer el archivo en la posición indicada. Dependiendo de la implementación, esto puede implicar leer un bloque completo de datos (en el caso de archivos de gran tamaño) o leer un registro o conjunto de registros.

        * En un archivo de base de datos, el bloque de datos puede contener varios registros, y el sistema buscará dentro del bloque el registro exacto que coincide con la clave de búsqueda.
        * Si la búsqueda corresponde a un archivo de texto o algún otro tipo de archivo donde cada registro es independiente, el sistema accederá al bloque exacto que contiene el dato.
    
    5. Devolución del resultado: una vez que se ha accedido al bloque o registro, el sistema devuelve el resultado de la búsqueda. En el caso de bases de datos, esto puede ser simplemente el valor del registro o una referencia al registro para una operación posterior.

        En sistemas de bases de datos, el resultado puede ser utilizado para realizar más consultas, modificaciones o incluso agregar nuevos registros. Si es necesario, el sistema puede actualizar el índice para reflejar los cambios en el archivo.

    6. Mantenimiento del índice: los índices no son estáticos y deben actualizarse con el tiempo. Cuando se insertan nuevos registros en el archivo, el índice debe ajustarse para reflejar las nuevas ubicaciones. Igualmente, cuando los registros son eliminados o modificados, el índice también debe actualizarse para mantener la consistencia entre la tabla de índice y el archivo.

        * Inserción de registros: Cuando un nuevo registro se agrega al archivo, el índice se actualiza para incluir la nueva clave y su dirección correspondiente.
        * Eliminación de registros: Si un registro es eliminado, el índice debe eliminar la clave asociada y ajustar las referencias para evitar que apunten a una dirección no válida.
        * Reorganización: En algunos casos, es posible que el índice se reestructure (especialmente en árboles B+) para mantener su eficiencia a medida que el archivo crece o se modifica.

**Escribe un pseudocódigo que muestre cómo acceder a:**

* Un archivo secuencialmente.
```
Abrir el archivo
Decidir si es modo lectura o escritura

Mientras no se haya terminado el archivo:
    Leer el siguiente registro
    Procesar el registro

Cerrar el archivo
```
* Un archivo directamente mediante su posición.
```
Abrir el archivo en modo lectura/escritura
Si el archivo está abierto correctamente:

    Posicionar el puntero en la posición deseada
    Leer el bloque de datos en la posición actual del puntero
    Si se está escribiendo:
        Escribir el nuevo dato 
    Procesar el dato leído o escrito

Cerrar el archivo
```
* Un archivo utilizando un índice.

```
Abrir el archivo en modo lectura
Si el archivo está abierto correctamente:
    Acceder a la tabla de índices que contiene la ubicación de los bloques de datos
    Buscar el índice correspondiente al registro o bloque deseado
    Si el índice es válido:
        Utilizar el índice para localizar el bloque de datos correspondiente
        Leer el bloque de datos de esa ubicación
        Procesar el dato leído
    Sino:
        Mostrar mensaje de error ("Índice no encontrado")
Cerrar el archivo
```

**Compara las ventajas de cada mecanismo dependiendo del caso de uso.**

1. Acceso Secuencial

Ventajas:

* Facilidad de implementación: El acceso secuencial es el más fácil de implementar y utilizar en cualquier sistema. Requiere poca o ninguna estructura de soporte adicional.
* Simplicidad para operaciones de lectura continua: Ideal para tareas que requieren procesamiento de archivos de principio a fin, como leer logs o archivos de texto sin necesidad de saltar posiciones.
* Bajo consumo de recursos: No requiere estructuras adicionales como índices o punteros, lo que significa que utiliza pocos recursos del sistema.
* Eficiencia en operaciones de escritura continua: Cuando un archivo se está escribiendo de forma continua (como en la grabación de datos en un archivo de log), el acceso secuencial es muy eficiente.

2. Acceso Directo (Aleatorio)

Ventajas:

* Acceso rápido y preciso: Permite leer o escribir en cualquier parte del archivo sin necesidad de procesar el archivo de manera secuencial, lo que mejora significativamente la eficiencia cuando solo se necesita un fragmento de datos.
* Ideal para archivos grandes con accesos esporádicos: Es perfecto cuando se deben realizar operaciones de lectura/escritura en archivos grandes sin necesidad de procesar el contenido completo.
* Optimiza el uso de recursos: Al poder acceder a cualquier parte del archivo de forma independiente, se reduce el uso de recursos al no tener que cargar el archivo completo en memoria.
* Mejor control sobre el almacenamiento: El acceso aleatorio es útil cuando se necesita un control específico sobre la ubicación de los datos, como en sistemas de bases de datos que requieren actualizaciones o búsquedas eficientes.

3. Acceso por Índice

Ventajas:

* Búsqueda eficiente: Gracias a la estructura indexada, la búsqueda de datos en archivos grandes es rápida, especialmente cuando se utilizan índices de búsqueda como árboles B+ que permiten búsquedas logarítmicas.
* Acceso rápido a registros específicos: Permite acceder a registros o bloques de datos específicos de forma eficiente sin necesidad de recorrer grandes volúmenes de información.
* Reducción de fragmentación: Al utilizar índices, los sistemas de archivos pueden reducir la fragmentación, ya que los bloques de datos pueden ser más fácilmente agrupados y localizados sin necesidad de desplazarse por todo el archivo.
* Escalabilidad: Los índices pueden ser extendidos o modificados para adaptarse a cambios en los datos, lo que hace que este método sea muy útil en aplicaciones que manejan grandes volúmenes de datos que cambian frecuentemente.
* Optimización de operaciones de búsqueda y actualización: Las operaciones de búsqueda, inserción y eliminación son rápidas, lo que lo hace ideal para bases de datos y sistemas que necesitan mantener una alta eficiencia en operaciones frecuentes.

### **Ejercicio 5: Modelo jerárquico y mecanismos de recuperación en caso de falla**

**Diseña un modelo jerárquico para un sistema de archivos con al menos tres niveles de directorios.**

```
/
├── usuario
│   └── checo
└── var
    ├── log
    ├── backup
    ├── config
    └── network
```
En este modelo la carpeta "/" es la raiz, después están las carpetas usuario y var al mismo nivel, y cada una de estas tiene directorios dentro de sí

**Simula una falla en un directorio específico y describe los pasos necesarios para recuperarlo.**

Supongamos que hay una falla en el directorio usuario/checo.

**Pasos para la recuperación:**

* Detección de la falla: Se detecta que el directorio checo está inaccesible.
* Verificación de la integridad del sistema: Usar comandos como fsck para verificar y reparar el sistema de archivos.

    ```bash
        fsck /dev/sdX
    ```

* Recuperación desde un respaldo: Si tienes una copia de seguridad del directorio checo, utiliza herramientas como rsync o cp para restaurarlo.

    ```bash
        rsync -av --progress /path/to/backup/checo /usuario/
    ```

Alternativamente, usa herramientas de recuperación de datos como TestDisk o PhotoRec.

**Explica qué herramientas o técnicas de respaldo (backup) utilizarías para evitar pérdida de datos.**

1. rsync: rsync es una herramienta de sincronización de archivos utilizada para copiar y sincronizar archivos y directorios entre diferentes ubicaciones. Es especialmente eficiente porque solo transfiere las partes de los archivos que han cambiado, en lugar de copiar todo el archivo nuevamente.

2. tar: tar (tape archive) es una utilidad de Unix/Linux utilizada para recopilar varios archivos en uno solo, a menudo para su respaldo o distribución. También puede comprimir archivos para ahorrar espacio de almacenamiento.

3. Cron jobs: Cron es un programador de tareas en sistemas Unix/Linux que permite la automatización de comandos o scripts en intervalos de tiempo regulares. Cron jobs se usan para programar tareas repetitivas, como realizar copias de seguridad automáticamente.

# Protección y Seguridad

## Ejercicio 1: Concepto y objetivos de protección y seguridad

**Define los conceptos de protección y seguridad en el contexto de sistemas operativos.**

![prot](prot.png)

La **protección** en sistemas operativos se refiere al conjunto de mecanismos y políticas diseñados para controlar el acceso a los recursos del sistema (como memoria, archivos, dispositivos y procesos) y garantizar que se utilicen de manera segura, eficiente y confiable. Su objetivo principal es prevenir accesos no autorizados y proteger los datos y recursos del sistema contra posibles amenazas internas o externas.

Aspectos clave de la protección en sistemas operativos

* Control de acceso: define qué usuarios o procesos tienen permiso para acceder a determinados recursos del sistema. Se implementa a través de permisos y mecanismos como listas de control de acceso (ACL), matrices de acceso o políticas basadas en roles.
* Integridad de los datos: Garantiza que los datos no sean alterados, corrompidos o manipulados por usuarios o procesos no autorizados. Los sistemas operativos deben proteger los archivos, bases de datos y demás recursos de almacenamiento.
* Aislamiento de procesos: Asegura que un proceso no pueda interferir con otro, accediendo a su memoria o recursos sin autorización. Esto se logra mediante mecanismos de aislamiento como la memoria virtual.
* Prevención de amenazas: Evita ataques como ejecución de código malicioso, explotación de vulnerabilidades, acceso no autorizado y denegación de servicios. Incluye mecanismos de protección contra malware, firewalls y actualizaciones de seguridad.
* Gestión de recursos compartidos: Controla cómo los recursos del sistema (CPU, memoria, almacenamiento, etc.) son compartidos entre múltiples usuarios o procesos para evitar conflictos o abusos.
* Autenticación y autorización: Verifica la identidad de los usuarios o procesos que intentan acceder al sistema (autenticación). Determina si tienen los permisos necesarios para realizar ciertas acciones (autorización).

La **seguridad** en sistemas operativos se refiere a la capacidad de un sistema para proteger sus recursos, datos y funcionalidades contra amenazas internas y externas, y garantizar la integridad, disponibilidad y confidencialidad de la información. A medida que el tiempo avanza y la tecnología se desarrolla, la seguridad también evoluciona y se adapta a los nuevos escenarios.

La creación de un sólido mecanismo de seguridad y protección en sistemas operativos es fundamental para salvaguardar la integridad de la información y garantizar la confianza de los usuarios en el funcionamiento del sistema. Para lograr este objetivo, se emplean estrategias tanto a nivel interno como externo, cada una con su propio enfoque y propósito.

Seguridad Externa

La seguridad externa engloba los mecanismos que actúan fuera del sistema operativo, orientados a prevenir amenazas físicas y controlar el acceso lógico de personas ajenas al sistema. Para cumplir con estos objetivos, se dividen en dos grandes grupos:

* Seguridad Física: La protección contra desastres y eventos adversos es esencial para asegurar la continuidad y disponibilidad de los sistemas. Para ello, se implementan medidas como la prevención, detección y eliminación de incendios, humos, inundaciones, y sobretensiones. Además, se controla la temperatura y limpieza del entorno para evitar daños a los equipos. El acceso físico a las instalaciones se regula mediante mecanismos de seguridad, como puertas con apertura por clave, identificación mediante tarjetas de acceso o reconocimiento de voz y huellas digitales.
* Seguridad de Administración: Los mecanismos de seguridad de administración tienen como objetivo impedir el acceso lógico de personas no autorizadas al sistema. Aquí se incluye la autenticación del usuario, donde se solicita un nombre de usuario (username) y una contraseña (password) para contrastar los datos y conceder o rechazar el acceso. Es fundamental fomentar prácticas seguras, como el cambio periódico de contraseñas y evitar tenerlas escritas en lugares visibles.
* Criptografía: También es una parte importante de la seguridad externa, donde se aplica un proceso de encriptado o cifrado a los datos para ocultar su contenido durante la transmisión.

Seguridad Interna

La seguridad interna se refiere a los mecanismos que operan dentro del propio sistema operativo, controlando y protegiendo aspectos críticos del funcionamiento y acceso a los recursos.

* Seguridad del Procesador: El procesador cuenta con mecanismos de protección, como estados protegidos y no protegidos (Kernel y Usuario), que definen los privilegios de acceso a recursos del sistema. También se utiliza un reloj hardware para evitar el bloqueo del procesador.
* Seguridad de la Memoria: En este ámbito, se aplican estrategias para evitar que un usuario acceda a la información de otro sin autorización. Entre ellas se encuentran los registros límites o frontera y el estado protegido y no protegido del procesador. Además, se emplean técnicas como la paridad o el checksum para asegurar la integridad de los datos almacenados.
* Seguridad de los Archivos: La protección de los archivos busca asegurar su disponibilidad y privacidad. Para garantizar la disponibilidad, se realizan copias de seguridad periódicas para recuperar datos en caso de pérdida o destrucción. En sistemas con múltiples usuarios, se emplean archivos LOG para registrar las operaciones y permitir recuperaciones precisas.

**Identifica los objetivos principales de un sistema de protección y seguridad, como confidencialidad, integridad y disponibilidad.**

* Confidencialidad

    La confidencialidad se refiere a la protección de la información frente a accesos no autorizados, esto implica asegurar que solo los usuarios, procesos o sistemas autorizados puedan acceder a los datos o recursos sensibles. Este objetivo es crucial en sistemas multiusuario donde varios individuos pueden compartir los mismos recursos físicos.

    El control de acceso y la autenticación son herramientas esenciales para mantener la confidencialidad. Las listas de control de acceso (ACL) permiten definir quién puede leer, escribir o ejecutar archivos específicos. Además, tecnologías como Secure Shell (SSH) o cifrado en discos (BitLocker) protegen los datos contra accesos externos no autorizados.

    La confidencialidad previene que usuarios malintencionados puedan interceptar información sensible, como contraseñas o claves de cifrado. Un fallo en este objetivo puede llevar a fugas de información confidencial y pérdida de confianza en el sistema.

* Integridad

    La integridad asegura que los datos se mantengan precisos y consistentes a lo largo del tiempo. Esto implica prevenir modificaciones no autorizadas y detectar cualquier cambio que pueda haber ocurrido. Por ejemplo, los sistemas operativos implementan controles para evitar que procesos sin privilegios modifiquen archivos críticos del sistema, como las configuraciones del kernel.

    Los sistemas de archivos incluyen herramientas como permisos de escritura y verificación de sumas de comprobación (checksum) para garantizar que los datos no sean manipulados. Además, el registro de auditorías permite rastrear cualquier intento de modificación no autorizado. Las tecnologías RAID también ayudan a mantener la integridad en los sistemas de almacenamiento mediante la duplicación de datos.

    La pérdida de integridad puede causar fallos críticos en el sistema. Por ejemplo, si un archivo del sistema operativo es modificado por un malware, esto podría comprometer la estabilidad y seguridad del sistema. Además, los errores humanos, como la sobrescritura accidental de archivos, también se previenen con medidas de protección de integridad.

* Disponibilidad

    La disponibilidad se asegura mediante la protección contra interrupciones no deseadas, como caídas del sistema, ataques de denegación de servicio (DoS) o fallos de hardware. Un sistema operativo debe gestionar los recursos de manera que las aplicaciones puedan ejecutarse sin interrupciones significativas.

    Los sistemas operativos implementan estrategias como el balanceo de carga, copias de seguridad, redundancia en hardware y mecanismos de recuperación de fallos para garantizar la disponibilidad. Además, el uso de sistemas de archivos robustos como NTFS o EXT4 puede prevenir la pérdida de datos en caso de fallos inesperados.

    La falta de disponibilidad puede resultar en una pérdida de productividad o incluso en daños financieros significativos, especialmente en sistemas críticos como servidores empresariales. Por ejemplo, un sistema que no pueda gestionar múltiples solicitudes simultáneamente puede verse sobrecargado, afectando su rendimiento y disponibilidad.

* Autenticidad

    La autenticidad se refiere a la garantía de que tanto los usuarios como los procesos son quienes dicen ser. Es fundamental para la seguridad en sistemas operativos, ya que evita que actores malintencionados accedan al sistema mediante suplantación de identidad, ésta implica la validación de credenciales como contraseñas, certificados digitales o tokens para asegurar que los accesos al sistema están siendo realizados por las entidades correctas. Sin autenticidad, los sistemas pueden ser vulnerables a ataques como la falsificación de identidad.

    La autenticidad implica la validación de credenciales como contraseñas, certificados digitales o tokens para asegurar que los accesos al sistema están siendo realizados por las entidades correctas. Sin autenticidad, los sistemas pueden ser vulnerables a ataques como la falsificación de identidad; para previenir esto, los sistemas operativos tienen herramientas; las herramientas comunes incluyen autenticación multifactor (MFA), certificados SSL/TLS y el uso de identificadores únicos para procesos y usuarios. Los sistemas operativos modernos también pueden integrar biometría, como huellas dactilares o reconocimiento facial, para aumentar la seguridad.

* Control de Acceso

    El control de acceso define qué operaciones (lectura, escritura, ejecución) pueden realizarse sobre un recurso específico y por quién. Por ejemplo, un archivo puede ser accesible solo por un administrador para escritura, mientras que otros usuarios pueden leerlo pero no modificarlo.

**Da un ejemplo práctico de cómo se aplican estos objetivos en un sistema operativo.**

En el mismo windows podemos ver esto, ya que nuestros datos personales y contraseñas están protegidos por ciertos protocolos, brindando así confidencialidad; es íntegro y disponible porque siempre que tengamos una laptop con widows podemos entrar y ejecutar sus doferentes procesos; tiene autenticidad porque se requiere de cierto control para poder entra/acceder y tiene control de acceso pues esto se ve a la hora de ejecutar los procesos y las diferentes tareas.

## Ejercicio 2: Clasificación aplicada a la seguridad

**Investiga las clasificaciones comunes de la seguridad, como física, lógica y de red y explica el papel de cada clasificación en la protección de un sistema operativo.**

* **Seguridad física:** La seguridad física se refiere a la protección de los componentes físicos del sistema operativo, como el hardware y los dispositivos de almacenamiento. Para garantizar la seguridad física, es necesario proteger el equipo de posibles robos o daños. Algunas medidas de seguridad física que se pueden implementar incluyen el uso de dispositivos de bloqueo, cámaras de seguridad y sistemas de alarmas.
* **Seguridad de red:** La seguridad de red se enfoca en proteger la red de comunicaciones de un sistema operativo. Esto incluye la protección contra ataques externos y la prevención de intrusiones en la red. Las medidas de seguridad de red incluyen el uso de firewalls, sistemas de detección de intrusiones y sistemas de prevención de intrusiones.
* **Seguridad de software:** La seguridad de software se enfoca en proteger el software del sistema operativo de posibles amenazas. Esto incluye la protección contra virus, malware y otros programas maliciosos que puedan dañar el sistema. Las medidas de seguridad de software incluyen el uso de antivirus, antispyware y firewalls de software.
* **Seguridad de datos:** La seguridad de datos se enfoca en proteger los datos almacenados en el sistema operativo. Esto incluye la protección contra el acceso no autorizado a los datos y la prevención de la pérdida de datos. Las medidas de seguridad de datos incluyen el cifrado de datos, la copia de seguridad regular de datos y la protección mediante contraseñas.
* **Seguridad de usuario:** La seguridad de usuario se enfoca en proteger las cuentas de usuario y los datos personales de los usuarios del sistema operativo. Esto incluye la protección contra el acceso no autorizado a las cuentas de usuario y la prevención de la pérdida de datos personales. Las medidas de seguridad de usuario incluyen el uso de contraseñas seguras y la autenticación de dos factores.

La seguridad física, de red, de software, de datos y de usuario son solo algunos ejemplos de las medidas de seguridad que se pueden utilizar para proteger un sistema operativo. Al implementar estas medidas de seguridad, se puede garantizar la protección de los datos y la privacidad de los usuarios.

**Proporciona ejemplos prácticos de herramientas o técnicas utilizadas en cada clasificación.**

* Seguridad de red 
    * Firewalls: Herramientas como iptables (en Linux) o Windows Firewall que filtran y controlan el tráfico de red entrante y saliente.
    * Sistemas de detección y prevención de intrusos (IDS/IPS): Ejemplos incluyen Snort o Suricata, que analizan el tráfico de red para detectar actividades sospechosas.
    * Red privada virtual (VPN): Protege las conexiones remotas hacia el sistema operativo mediante túneles cifrados.

* Seguridad de software
    * Actualizaciones y parches: Aplicar regularmente actualizaciones del sistema operativo y software para corregir vulnerabilidades.
    * SELinux o AppArmor: Herramientas en Linux que refuerzan las políticas de seguridad del sistema operativo.
    * Antivirus y antimalware: Programas como ClamAV en Linux o Windows Defender para detectar y eliminar software malicioso.

* Seguridad de datos
    * Cifrado de discos: Herramientas como BitLocker (Windows) o LUKS (Linux) para proteger datos almacenados en el disco.
    * Copia de seguridad: Uso de herramientas como rsync (Linux) o sistemas de respaldo en la nube para prevenir pérdida de datos.
    * Protección contra ransomware: Configuración de sistemas para evitar el cifrado malicioso de archivos críticos.
    * Gestión de permisos: Establecer permisos granulares sobre archivos y carpetas.
    * Protección de datos en tránsito: Uso de protocolos como HTTPS y SFTP para proteger los datos enviados a través de la red.

Solo encontré de esos 3, perdón :)

## Ejercicio 3: Funciones del sistema de protección

**Describe cómo un sistema de protección controla el acceso a los recursos y explica las funciones principales como autenticación, autorización y auditoría.**

Un sistema de protección controla el acceso a los recursos mediante la implementación de políticas y mecanismos que regulan quién puede acceder, cómo, y bajo qué condiciones. Estos mecanismos funcionan en múltiples niveles del sistema operativo, asegurando que los recursos físicos y lógicos estén protegidos contra accesos no autorizados.

1. **Identificación de usuarios y procesos:** Cada usuario y proceso en el sistema tiene un identificador único (como un UID en Linux) que se utiliza para diferenciar quién está solicitando acceso a los recursos.
2. **Listas de control de acceso (ACL):** estas listas asocian permisos específicos (como lectura, escritura, o ejecución) con usuarios o grupos de usuarios para cada recurso. Por ejemplo, un archivo puede ser accesible en modo lectura para un usuario y en modo escritura para otro.
3. **Políticas de seguridad:** el sistema aplica reglas predefinidas que determinan cómo se pueden utilizar los recursos. Estas políticas pueden incluir restricciones basadas en roles (RBAC), tiempos de acceso, o ubicaciones.
4. **Supervisión activa:** el sistema opera con controles dinámicos, como bloqueo de recursos tras varios intentos fallidos o revocación de permisos si se detecta un comportamiento anómalo.

Cómo funciona la vigilancia del sistema

La vigilancia juega un papel fundamental para garantizar la integridad y protección del sistema operativo. Se lleva a cabo mediante diversos mecanismos que permiten identificar posibles amenazas y detectar actividades sospechosas:

1. **Monitoreo de Amenazas:** Consiste en establecer rutinas de control en el sistema operativo que evalúan el acceso de los usuarios y las operaciones que desean realizar sobre los archivos del sistema. El monitoreo de amenazas permite detectar intentos de penetración al sistema y emite advertencias para tomar medidas preventivas.
2. **Autenticación:** la autenticación verifica la identidad de los usuarios o procesos que intentan acceder al sistema.
3. **Amplificación:** En ciertas ocasiones, los programas de vigilancia necesitan derechos de acceso adicionales para interactuar con los programas de usuario y los archivos del sistema. Esta situación se conoce como amplificación, y su objetivo es garantizar que las rutinas de control puedan llevar a cabo sus funciones correctamente sin comprometer la seguridad del sistema.
4. **Protección por Contraseña:** La protección por contraseña es uno de los esquemas más comunes para la autenticación de usuarios. Sin embargo, este método puede resultar débil si los usuarios eligen contraseñas fáciles de adivinar. Para aumentar la seguridad, se recomienda el uso de contraseñas largas y complejas.
5. **Autorización:** la autorización determina si un usuario autenticado tiene permiso para realizar una acción específica sobre un recurso, en otras palabras, evalúa las políticas de acceso y permisos asignados al usuario o proceso para garantizar que solo las operaciones permitidas sean ejecutadas.
6. **Auditoría:** La auditoría registra automáticamente cada evento importante que ocurre en el sistema de computación y se almacena en un área protegida. Los auditores examinan las transacciones recientes para detectar actividad fraudulenta o intentos de intrusión. Las auditorías periódicas y al azar son herramientas valiosas para mantener la seguridad del sistema.
7. **Controles de Acceso:** Los derechos de acceso definen los privilegios que tienen los sujetos sobre los objetos en el sistema. Los derechos de acceso más comunes incluyen lectura, escritura y ejecución.
8. **Políticas:** La matriz de acceso proporciona el mecanismo para establecer diversas políticas de seguridad. Estas políticas definen qué derechos deben incluirse en las entradas de la matriz para garantizar la protección adecuada.
9. **Criptografía:** La criptografía es una técnica utilizada para transformar datos de manera que solo el usuario destinatario pueda comprenderlos. Se aplica para garantizar la privacidad y evitar la no autorización en la extracción de información en las comunicaciones.

Mediante la implementación adecuada de estos mecanismos de vigilancia, los sistemas operativos pueden fortalecer su seguridad y protegerse eficazmente contra las amenazas cibernéticas en constante evolución.

**Diseña un caso práctico donde se muestren las funciones de un sistema de protección en acción.**

Escenario:

Una empresa utiliza un servidor centralizado que gestiona documentos internos para diferentes departamentos, como Recursos Humanos (RRHH) y Finanzas. Este servidor está protegido por un sistema operativo que implementa funciones avanzadas de autenticación, autorización y auditoría.

Implementación del sistema de protección:

1. **Autenticación:**

    * Los empleados deben autenticarse utilizando credenciales únicas y autenticación multifactor (contraseña más un código enviado al móvil).
    * Solo los usuarios registrados tienen acceso al servidor.

2. **Autorización:**

    * Los empleados de RRHH tienen permiso para acceder únicamente a documentos de su departamento con privilegios de lectura y escritura.
    * El departamento de Finanzas puede acceder a sus propios documentos y generar reportes, pero no puede modificar documentos relacionados con RRHH.
    * El administrador tiene permisos de acceso completos, incluyendo la gestión de usuarios y permisos.

3. **Auditoría:**

    * Todas las acciones se registran en un archivo de auditoría, incluyendo accesos, modificaciones y errores de autenticación.
    * El administrador revisa los registros semanalmente para identificar accesos sospechosos o violaciones de las políticas de seguridad.

Ejecución práctica:

* Un empleado de Finanzas accede al servidor y genera un reporte financiero después de autenticarse con MFA. El sistema autoriza la acción al verificar que tiene los permisos adecuados.
* Un intento no autorizado de acceder a documentos de RRHH es bloqueado, y el incidente queda registrado en la auditoría.
* El administrador revisa los registros y detecta intentos fallidos repetidos desde una dirección IP desconocida. En respuesta, el acceso desde esa dirección se bloquea automáticamente.

## Ejercicio 4: Implantación de matrices de acceso

* **Diseña una matriz de acceso para un sistema con al menos 3 usuarios y 4 recursos.**
* **Explica cómo esta matriz se utiliza para controlar el acceso en un sistema operativo.**
* **Simula un escenario donde un usuario intenta acceder a un recurso no permitido y cómo la matriz lo bloquea.**

![ma](ma.jpg)

**Situación:** El Usuario 3 intenta escribir en el Recurso 1 (Archivo A).

Consulta a la matriz de acceso:
* El sistema operativo verifica la celda correspondiente a "Usuario 3" y "Recurso 1".
* En la matriz, se observa que el Usuario 3 no tiene ningún permiso para el Recurso 1.

Acción del sistema:

El sistema bloquea el intento de escritura y genera un mensaje de error o un evento de auditoría indicando un intento no autorizado.

Mensaje generado:
```
Acceso denegado: El Usuario 3 no tiene permisos para escribir en el Recurso 1 (Archivo A).
```

##  Ejercicio 5: Protección basada en el lenguaje

**Explica el concepto de protección basada en el lenguaje.**

La protección basada en el lenguaje es una estrategia que utiliza las características intrínsecas de los lenguajes de programación para definir y reforzar políticas de seguridad y control de acceso dentro de un sistema. A diferencia de los mecanismos de protección implementados a nivel de hardware o sistema operativo, este enfoque permite que las restricciones y permisos se especifiquen directamente en el código fuente, ofreciendo una descripción de alto nivel para la asignación y uso de recursos.

Una de las principales ventajas de este método es la capacidad de declarar de manera explícita las necesidades de protección dentro del propio lenguaje. Esto facilita al programador la especificación de restricciones y permisos sin depender exclusivamente de las configuraciones del sistema operativo o del hardware subyacente. Además, cuando el hardware no proporciona soporte directo para ciertas medidas de seguridad, la implementación del lenguaje puede ofrecer soluciones basadas en software para hacer cumplir las políticas de protección.

Este enfoque también permite una mayor portabilidad y flexibilidad en la aplicación de políticas de seguridad. Al estar integradas en el código fuente, las especificaciones de protección pueden interpretarse y adaptarse a diferentes entornos y plataformas, generando las llamadas necesarias en cualquier sistema de protección provisto por el hardware y el sistema operativo. Esto es especialmente útil en sistemas heterogéneos donde las capacidades de seguridad del hardware pueden variar significativamente. 

Sin embargo, es importante reconocer que la protección basada en el lenguaje no reemplaza a los mecanismos tradicionales de seguridad implementados en el hardware o el sistema operativo. Más bien, actúa como una capa adicional que refuerza la seguridad del sistema al permitir una especificación más detallada y contextual de las políticas de protección. La combinación de múltiples niveles de protección, desde el hardware hasta el código fuente, ofrece una defensa más robusta contra accesos no autorizados y otras amenazas a la seguridad.

**Proporciona un ejemplo de cómo un lenguaje como Java o Rust asegura la memoria y evita accesos no autorizados.**

Rust

Rust es un lenguaje de programación que pone un énfasis particular en la seguridad y la gestión eficiente de la memoria, sin sacrificar el rendimiento. Una de las características más destacadas de Rust es su sistema de ownership (propiedad), que define reglas claras sobre cómo se posee y comparte la memoria entre diferentes partes del programa. Este sistema garantiza que cada fragmento de memoria tenga un único propietario en un momento dado, eliminando la posibilidad de accesos concurrentes no controlados y evitando condiciones de carrera.

Además del sistema de propiedad, Rust introduce el concepto de borrowing (préstamo) y referencias, que permiten a los desarrolladores acceder a la memoria sin transferir la propiedad. Las reglas de préstamo aseguran que no puede haber referencias mutables múltiples a la misma ubicación en memoria simultáneamente, previniendo así la corrupción de datos y otros errores relacionados con la concurrencia.

Rust también cuenta con un sistema de tipos estático y una verificación en tiempo de compilación que detecta posibles errores de memoria antes de que el programa se ejecute. Esto incluye la detección de dangling pointers (punteros colgantes), accesos a memoria no inicializada y otros problemas comunes en la gestión manual de memoria. Al identificar estos errores en la fase de compilación, Rust reduce significativamente las vulnerabilidades de seguridad en tiempo de ejecución.

Otra característica importante es que Rust no requiere un recolector de basura en tiempo de ejecución, lo que permite un control más preciso sobre el uso de la memoria y reduce la sobrecarga asociada con la gestión automática. Esto es particularmente beneficioso en aplicaciones de sistemas y en entornos con recursos limitados, donde el rendimiento y la eficiencia son críticos.

Finalmente, Rust promueve prácticas de programación segura a través de su enfoque en la inmutabilidad por defecto y la concurrencia segura. Al fomentar que las variables sean inmutables a menos que se especifique lo contrario, y al proporcionar abstracciones para la concurrencia que previenen errores comunes, Rust ayuda a los desarrolladores a escribir código más seguro y robusto.

**Compara este enfoque con otros mecanismos de protección en sistemas operativos.**

Los sistemas operativos Unix y Linux implementan mecanismos de protección a nivel de sistema que son fundamentales para la seguridad y estabilidad del entorno. Estos mecanismos incluyen la gestión de permisos de archivos, la separación de privilegios de usuario y la implementación de modelos de seguridad como el de usuario raíz (root) y usuarios regulares.

En Unix y Linux, cada archivo y proceso tiene asociados permisos que determinan quién puede leer, escribir o ejecutar. Estos permisos se asignan a nivel de usuario, grupo y otros, proporcionando un control granular sobre el.

## Ejercicio 6: Validación y amenazas al sistema

**Investiga y describe al menos tres tipos de amenazas comunes (por ejemplo, malware, ataques de fuerza bruta, inyección de código).**

* Malware: El término se refiere de forma genérica a cualquier software malicioso que tiene por objetivo infiltrarse en un sistema para dañarlo. Comúnmente se asocian como tipos de malware a los virus, gusanos y troyanos.
* Virus: Es un código que infecta los archivos del sistema mediante un programa maligno, pero para ello necesita que el usuario lo ejecute directamente. Una vez activo, se disemina por todo el sistema a donde el equipo o cuenta de usuario tenga acceso, desde dispositivos de hardware hasta unidades virtuales o ubicaciones remotas en una red.
* Gusanos: Es un programa que, una vez infectado el equipo, realiza copias de sí mismo y las difunde por la red. A diferencia del virus, no necesita la intervención del usuario, ya que pueden transmitirse utilizando las redes o el correo electrónico. Son difíciles de detectar, pues su objetivo es difundirse e infectar a otros equipos, y no afectan inicialmente el funcionamiento normal del sistema. Su uso principal es el de la creación de redes zombis (botnets), utilizadas para ejecutar acciones de forma remota como ataque de denegación de servicio (DoS) a otro sistema.
* Troyanos: Similares a los virus, sin embargo, mientras que este último es destructivo por sí mismo, el troyano lo que busca es abrir una puerta trasera (backdoor) para favorecer la entrada de otros programas maliciosos. Su misión es precisamente pasar desapercibido e ingresar a los sistemas sin que sea detectado como una amenaza potencial. No se propagan a sí mismos y suelen estar integrados en archivos ejecutables aparentemente inofensivos.
* Spyware: Es un programa espía, cuyo objetivo es recopilar información de un equipo y transmitirlo a una entidad externa sin el consentimiento del propietario. Su trabajo suele ser silencioso, sin dar muestras de su funcionamiento, llegando incluso a instalar otros programas sin que se perciban. Las consecuencias de su infección incluyen, además, pérdida considerable del rendimiento del sistema y dificultad para conectarse a Internet.
* AdWare: Su función principal es la de mostrar publicidad. Aunque su intención no es la de dañar equipos, es considerado por algunos una clase de spyware, ya que puede llegar a recopilar y transmitir datos para estudiar el comportamiento de los usuarios y orientar mejor el tipo de publicidad.
* Ransomware: Este es uno de los más sofisticados y modernos ataques, ya que lo que hace es secuestrar datos (encriptándolos) y pedir un rescate por ellos. Normalmente, se solicita una transferencia en dinero electrónico (bitcoins), para evitar el rastreo y localización. Este tipo de ciberataque va en aumento y es uno de los más temidos en la actualidad.
* Escaneo de Puertos: Técnica empleada para auditar dispositivos y redes con el fin de conocer que puertos están abiertos o cerrados, los servicios que son ofrecidos, así como comprobar la existencia de algún corta fuegos (firewall), la arquitectura de la red, o el sistema operativo, entre otros aspectos. Su empleo permite al atacante realizar un análisis preliminar del sistema y sus vulnerabilidades, con miras a algún otro tipo de ataque, pues cada puerto abierto en un dispositivo, es una potencial puerta de entrada al mismo.
* Phishing: No es un software, se trata más bien de diversas técnicas de suplantación de identidad para obtener datos privados de las víctimas, como contraseñas o datos bancarios. Los medios más utilizados son el correo electrónico, mensajería o llamadas telefónicas, y se hacen pasar por alguna entidad u organización conocida, solicitando datos confidenciales, para posteriormente utilizarse por terceros en beneneficio propio.
* Botnets (Redes de robots): Son computadoras o dispositivos conectados a la red (teléfonos inteligentes, tabletas, etc.) infectados y controlados remotamente, que se comportan como robots (bots) o “zombis”, quedando incorporados a redes distribuidas, las cuales envían de forma masiva mensajes de correo “spam” o código malicioso, con el objetivo de atacar otros sistemas o dejarlos fuera de servicio.
* Denegación de Servicios: Tiene como objetivo inhabilitar el uso de un sistema o computadora, con el fin de bloquear el servicio para el que está destinado. Los servidores web poseen la capacidad de resolver un número determinado de peticiones o conexiones de usuarios de forma simultánea, en caso de superar ese número, comienzan a ralentizarse o incluso bloquearse y desconectarse de la red. Existen dos técnicas para este ataque: la denegación de servicio o DoS (Denial of Service) y la denegación de servicio distribuido o DDoS (Distributed Denial of Service); la diferencia entre ambos es el número de ordenadores que realizan el ataque. En el primero, las peticiones masivas al servicio se realizan desde una misma máquina o dirección IP, consumiendo así los recursos que ofrece el servicio hasta que no tiene capacidad de respuesta y comienza a rechazar peticiones (denegar el servicio); en el segundo, las peticiones o conexiones se realizan empleando un gran número de computadoras o direcciones IP, todas al mismo tiempo y hacia el mismo servicio objeto del ataque, de forma general, las computadoras que lo realizan se encuentran infestadas, formando parte de una botnet, y comportándose como zombis.
* Ataque MITM (Man In The Middle): Conocido como “Hombre en el Medio”, ocurre cuando una comunicación entre dos sistemas es interceptada por una entidad externa simulando una falsa identidad. En este sentido, el atacante tiene control total de la información que se intercambia, pudiendo manipularla a voluntad, sin que el emisor y el receptor lo perciban rápidamente. Es común que se realice empleando redes WIFI públicas y abiertas, y es muy peligroso ya que se puede obtener información sensible de las víctimas, y es difícil identificarlo si no se poseen unos mínimos conocimientos sobre el tema.

**Explica los mecanismos de validación como autenticación multifactor y control de integridad.**

**Autenticación Multifactor**

La autenticación de multifactores requiere que los usuarios proporcionen varios fragmentos de información cuando inicien sesión en el sistema para demostrar su identidad. La autenticación multifactor utiliza cualquier combinación de dos o más métodos, llamados factores, para autenticar a los usuarios en sus recursos y proteger dichos recursos frente a un acceso no autorizado.

Uno de los conceptos clave de la autenticación multifactor es que cada factor procede de una categoría diferente. Estas categorías incluyen las siguientes:

* **Algo que un usuario conoce:** el usuario se autentica con información que solo conoce él como, por ejemplo, una contraseña o un PIN.
* **Algo que tiene un usuario:** el usuario demuestra su identidad con información que le facilita un servicio de autenticación de confianza como, por ejemplo, un código de paso de uso único generado por un dispositivo móvil o aplicación.
* **Algo que un usuario es:** el usuario demuestra su identidad con técnicas biométricas como, por ejemplo, huellas dactilares o exploraciones retinianas.

**Control de integridad**

Así pues, una herramienta de control de integridad es aquella que verifica, contrastando con una base de datos de hechos conocidos, el estado de un sistema para determinar los cambios que en él se han producido. Si bien se puede tratar de una herramienta útil para la gestión de configuraciones, su aplicación al mundo de la seguridad viene derivada de su capacidad para detectar ataques producidos a un sistema ya que, en la gran mayoría de los casos, un intruso realizará cambios en  el sistema que dicha herramienta de control de integridad podrá detectar. Aunque en algunos casos pueda ser dudosa la intrusión porque, al fin y al cabo, el sistema operativo puede modificarse a sí mismo durante su propio funcionamiento; en otros casos, en los que la pérdida de integridad del sistema es notoria, se presenta un claro síntoma de que tanto el sistema como la seguridad del mismo se ha visto alterada y superada por un usuario malicioso o un intruso.

Las herramientas de control de integridad también pueden utilizarse para un análisis postmortem de un equipo. Su uso se extiende más allá, pudiéndose utilizar para realizar un análisis forense de un sistema que se haya visto comprometido. Esto se debe a que la herramienta podrá proporcionar gran cantidad de información: ficheros creados, modificados o borrados, variaciones en el contenido de ficheros, etc. Esto puede ser útil para conocer “el qué” y “el cómo” del ataque sufrido (el “por qué” es más difícil de determinar), lo que permite hacerse una idea del ataque y sus consecuencias, aportando información suficiente para evitar en gran medida que hechos así se vuelvan a producir.

Sea cual sea el uso que le demos a este sistema de verificación, el procedimiento para llevar a cabo un control exhaustivo de la integridad del sistema será siempre el mismo para la mayoría de los sistemas operativos. Se basa el procedimiento en unos sencillos pasos:

* Generar una base de datos de integridad tras la instalación del sistema. Esta información servirá de referencia posteriormente y deberá excluir aquellos archivos que se verán modificados de manera habitual, por procesos propios del sistema (archivos de registro, archivos de colas, ubicaciones temporales, etc.). Esta base de datos deberá almacenarse en un medio físico de sólo lectura (para impedir su modificación posterior).
* Periódicamente se deberá generar una nueva base de datos y contrastar ésta con la base de datos de referencia, para verificar lo posibles cambios que se han producido en el sistema. 
* Regenerar la base de datos de referencia cuando se realice una tarea administrativa (instalar parches, realizar cambios a la configuración del sistema).

## Ejercicio 7: Cifrado

**Define los conceptos de cifrado simétrico y asimétrico.**

**Cifrado simétrico**

En el cifrado simétrico, sólo hay una clave, y todas las partes implicadas utilizan la misma clave para cifrar y descifrar la información. Al utilizar una única clave, el proceso es sencillo, como en el siguiente ejemplo: encriptas un correo electrónico con una clave única, envías ese correo a tu amigo David, y él utilizará la misma clave simétrica para desbloquear/desencriptar el correo.

![cifrados](cs.png)

Las ventajas de este tipo de cifrado son su mayor rendimiento y su bajo consumo de recursos, pero es intrínsecamente más antiguo y menos seguro que su homólogo. La razón es sencilla: si usas una única clave para toda la empresa, significa que estás poniendo toda tu confianza en una clave que tendrás que compartir mucho.

Por esta razón, el cifrado simétrico es estupendo cuando se trabaja con datos sensibles a gran escala, o en tareas de cifrado que pretenden ocultar permanentemente la información sin necesidad de descifrarla. Por ejemplo, cuando se activa BitLocker en un ordenador con Windows para cifrar todos los discos duros. Al desbloquear el PC con su código de acceso, el usuario descifrará los datos sin riesgo de exponer su clave secreta de cifrado. Otro ejemplo son las VPN, que cifran su tráfico de red con una clave local y no tienen la necesidad de compartirla fuera de su propio uso.

Algunos ejemplos de cifrado simétrico son:

1. AES (Advanced Encryption Standard):
    * Es uno de los algoritmos de cifrado más utilizados en el mundo. Fue adoptado como estándar de cifrado por el gobierno de los Estados Unidos y es conocido por su eficiencia y seguridad.
    * Usos comunes: Protección de datos en disco, conexiones seguras en la web (HTTPS), y aplicaciones de cifrado de archivos.

2. DES (Data Encryption Standard):
    * Fue uno de los primeros algoritmos de cifrado ampliamente adoptados. Utiliza una clave de 56 bits, lo que hoy en día se considera inseguro debido a su vulnerabilidad a ataques de fuerza bruta.
    * Usos comunes: Aunque es obsoleto, DES se utiliza a veces en sistemas heredados.

3. 3DES (Triple DES):
    * Mejora la seguridad de DES al aplicar el algoritmo tres veces con diferentes claves. Es más seguro que DES, pero también más lento.
    * Usos comunes: Sistemas bancarios y financieros.

**Cifrado asimétrico**

El cifrado asimétrico, por otro lado, se creó para resolver el problema inherente al cifrado simétrico: la necesidad de compartir una única clave de cifrado alrededor que se utiliza tanto para cifrar como para descifrar datos.

![cifrados](ca.png)

Este tipo de cifrado, más nuevo y seguro, utiliza dos claves para su proceso de cifrado: la clave pública, utilizada para el cifrado, y la clave privada, utilizada para el descifrado. Estas claves están relacionadas, conectadas, y funcionan de la siguiente manera:

La clave pública está disponible para cualquiera que necesite encriptar una información. Esta clave no sirve para el proceso de descifrado. Un usuario necesita tener una clave secundaria, es decir, la clave privada, para descifrar esta información. De este modo, la clave privada sólo la tiene el actor responsable de descifrar la información, sin sacrificar la seguridad a medida que se escala la seguridad.

Asimismo, otros usos del cifrado asimétrico son:

* Compartir una clave simétrica de manera segura, que luego se puede utilizar para el cifrado simétrico de datos grandes.
* Verificar la autenticidad y la integridad de un mensaje o documento.

Este tipo de cifrado es de especial utilidad para certificados SSL/TLS, criptomonedas, email seguro (PGP/GPG) y autenticación de usuarios.

En cuanto al aspecto de la seguridad es importante recalcar que se basa en problemas matemáticos difíciles de resolver, como la factorización de números grandes (en RSA) o el problema del logaritmo discreto (en ECC).

No obstante, algunas de sus desventajas son: 

* Es más lento que el cifrado simétrico debido a los cálculos matemáticos complejos.
* Las claves suelen ser más largas, lo que puede aumentar la carga de procesamiento y almacenamiento.

Ejemplos de cifrado asimétrico

Un buen ejemplo es el cifrado del correo electrónico. Con el cifrado asimétrico, cualquiera puede utilizar tu clave pública para enviarte un correo electrónico cifrado que sólo puedes descifrar con tu clave privada.

Naturalmente, el asimétrico es un estándar de cifrado más avanzado y, por lo tanto, es más lento y consume más recursos. Por ello, suele utilizarse en transacciones más pequeñas, normalmente para establecer canales de comunicación seguros o autenticar usuarios.

Algunos de los ejemplos de este tipo de cifrado son: 

1. RSA (Rivest-Shamir-Adleman):
    * Es uno de los algoritmos de cifrado asimétrico más antiguos y ampliamente utilizados. Se basa en la dificultad de factorizar grandes números primos. Además, la seguridad de RSA aumenta con el tamaño de la clave (típicamente 2048 bits o más).
    * Usos comunes: Firmas digitales, cifrado de datos sensibles, y protección de comunicaciones en internet (SSL/TLS).

2. ECC (Elliptic Curve Cryptography):
    * Utiliza las propiedades matemáticas de las curvas elípticas para proporcionar seguridad. Ofrece una seguridad comparable a RSA pero con claves mucho más pequeñas. Proporciona un nivel de seguridad similar a claves de RSA mucho más grandes. 
    * Usos comunes: SSL/TLS, criptomonedas (como Bitcoin), y aplicaciones móviles debido a su eficiencia.

3. DSA (Digital Signature Algorithm):
    * Es un estándar de firma digital adoptado por el Instituto Nacional de Estándares y Tecnología (NIST) de EE.UU. Se basa en el problema del logaritmo discreto. Proporciona integridad y autenticidad a través de firmas digitales.
    * Usos comunes: Autenticación y verificación de documentos electrónicos y software.

![cifrados](cifrados.png)

**Proporciona un ejemplo práctico de cada tipo de cifrado aplicado en sistemas operativos.**

**Cifrado simétrico:** Cifrado de disco completo en Windows con BitLocker

Windows ofrece una función de seguridad llamada BitLocker, que utiliza el cifrado simétrico con AES para proteger el contenido de los discos duros de los dispositivos. Al activar BitLocker, todo el contenido del disco (incluidos archivos, aplicaciones y configuraciones del sistema operativo) se cifra utilizando una clave secreta.

Funcionamiento:

* Cuando el usuario intenta acceder al sistema, BitLocker utiliza la clave secreta para descifrar el disco y permitir el acceso a los datos.
* La clave secreta debe ser almacenada de manera segura, generalmente en un TPM (Trusted Platform Module) o proporcionada por el usuario a través de un PIN.
* Si el disco se extrae y se conecta a otro sistema, sin la clave correcta, los datos permanecerán cifrados y protegidos.

**Cifrado asimétrico:** Autenticación SSH en Linux

SSH es un protocolo de red utilizado para acceder de manera remota a sistemas Linux y Unix. Para asegurar la autenticación, SSH puede utilizar cifrado asimétrico, en el que se emplea un par de claves (pública y privada) para garantizar que las comunicaciones sean seguras y que solo usuarios autorizados puedan acceder al sistema.

Funcionamiento:

* Un usuario genera un par de claves: una clave pública que se coloca en el archivo `~/.ssh/authorized_keys` en el servidor, y una clave privada que permanece en la máquina local del usuario.
* Cuando el usuario intenta acceder al servidor a través de SSH, el servidor utiliza la clave pública para cifrar un reto (generalmente un número aleatorio), que solo puede ser descifrado por la clave privada correspondiente. Si el usuario responde correctamente, se establece una conexión segura.

**Simula el proceso de cifrado y descifrado de un archivo con una clave dada.**

**Cifrado simétrico**

1. Archivo Original: `mensaje.txt`
    
    Contenido:

    ```
    Este es un archivo confidencial.
    ```

2. Clave de cifrado

    ```
    MiClaveSecreta123
    ```

3. Proceso de cifrado:

    * El algoritmo AES toma el contenido del archivo y la clave.
    * Convierte el archivo en bloques de datos cifrados utilizando la clave.
    * Resultado cifrado

    ```
    YWFjMTIzY2NkZGVmYzY3ZGU2NDY=
    ```

4. Proceso de descifrado:

    * Se utiliza la misma clave (MiClaveSecreta123) para descifrar los bloques cifrados.
    * El contenido original del archivo se recupera:

    ```
    Este es un archivo confidencial.
    ```

**Cifrado Asimétrico:**

Archivo Original: `mensaje.txt`

Contenido:

```
Este es un archivo confidencial.
```

1. Generaion de claves
    * clave pública

    ```
        -----BEGIN PUBLIC KEY-----
        MIIBIjANBgkqh...
        -----END PUBLIC KEY-----
    ```

    * Clave privada

    ```
        -----BEGIN PRIVATE KEY-----
        MIIEvQIBADANBg...
        -----END PRIVATE KEY-----

    ```
2. Proceso de cifrado:

    * Se usa la clave pública para cifrar el contenido del archivo.
    * El archivo cifrado contiene datos como:
    ```
        PEBRM1RYUlBBQT09DQ==

    ```

3. Proceso de descifrado.

    * Se utiliza la clave privada para descifrar los datos cifrados.
    * El contenido original del archivo se recupera: 
    ```
        Este es un archivo confidencial.
    ```
