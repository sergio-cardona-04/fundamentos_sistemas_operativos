# Comandos de Entrada y Salida, Discos y Archivos

## Ejercicio 1: Montar y Desmontar Discos

* Objetivo: Aprender a montar y desmontar un dispositivo externo.
* Inserta una memoria USB en el sistema.
* Encuentra el dispositivo usando el comando: `lsblk` o `fdisk -l`

``` bash
Disk /dev/sdb: 16 GiB, 17179869184 bytes, 33554432 sectors
Disk model: Cruzer Blade
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
Disklabel type: dos
Disk identifier: 0x12345678

Device     Boot Start      End  Sectors  Size Id Type
/dev/sdb1        2048 33554431 33552384   16G  b W95 FAT32
```

* Monta la memoria USB en un directorio, por ejemplo, `/mnt/usb`:

``` bash

    No salió nada

```

* Verifica que esté montado correctamente:

```bash
/dev/sdb1        16G   1M   15G   1% /mnt/usb
```
* Copia un archivo desde tu directorio personal al dispositivo USB:

```bash
cp ~/doc.txt /mnt/usb/

```

* Desmonta la memoria USB:

```
sudo umount /mnt/usb
```

``` bash
    Otra vez no dió nada
```

``` bash
NAME   MAJ:MIN RM  SIZE RO TYPE MOUNTPOINT
sda      8:0    0  500G  0 disk 
├─sda1   8:1    0  100G  0 part /
├─sda2   8:2    0  400G  0 part /home
```

## Ejercicio 2: Redirección de Entrada y Salida

* Objetivo: Usar redirección para guardar la salida de comandos en archivos
* Lista los archivos de tu directorio actual y guarda el resultado en un archivo `listado.txt`:
* Muestra el contenido del archivo en la terminal:
* Añade la fecha actual al final del archivo:
* Muestra todo el contenido del archivo nuevamente:

```bash
vboxuser@uwuntu:~/Desktop$ sudo ls -l > listado.txt
[sudo] password for vboxuser: 
vboxuser@uwuntu:~/Desktop$ sudo cat listado.txt
total 0
-rw-rw-r-- 1 vboxuser vboxuser 0 Dec 18 19:28 listado.txt
vboxuser@uwuntu:~/Desktop$ date >> listado.txt
vboxuser@uwuntu:~/Desktop$ cat listado.txt
total 0
-rw-rw-r-- 1 vboxuser vboxuser 0 Dec 18 19:28 listado.txt
Wed Dec 18 07:28:44 PM UTC 2024
vboxuser@uwuntu:~/Desktop$ 
```

## Ejercicio 3: Copiar y Mover Archivos

* Objetivo: Practicar copiar y mover archivos y directorios.
* Crea un archivo de texto llamado `archivo1.txt`:
* Copia este archivo a otro directorio, por ejemplo, `/tmp`:
* Renombra el archivo copiado a `archivo2.txt` en `/tmp`:
* Mueve el archivo `archivo2.txt` de vuelta a tu directorio actual:

```bash
vboxuser@uwuntu:~/Desktop$       echo "Archivo de prueba" > archivo1.txt
vboxuser@uwuntu:~/Desktop$ cp archivo1.txt /tmp/
vboxuser@uwuntu:~/Desktop$ mv /tmp/archivo1.txt /tmp/archivo2.txt
vboxuser@uwuntu:~/Desktop$   mv /tmp/archivo2.txt .
vboxuser@uwuntu:~/Desktop$ 
```

## Ejercicio 4: Comprimir y Descomprimir Archivos

* Objetivo: Aprender a trabajar con compresión de archivos.
* Crea un directorio llamado `backup` y copia algunos archivos en él.
* Comprime el directorio `backup` en un archivo `.tar.gz`:
* Borra el directorio original y extrae el contenido del archivo comprimido:

```bash
vboxuser@uwuntu:~/Desktop$ tar -czvf backup.tar.gz backup/
backup/
vboxuser@uwuntu:~/Desktop$ tar -xzvf backup.tar.gz
backup/
vboxuser@uwuntu:~/Desktop$ tar -xzvf backup.tar.gz
backup/
vboxuser@uwuntu:~/Desktop$ 
```

## Ejercicio 5: Permisos y Propiedades de Archivos

* Objetivo: Aprender a modificar permisos y propietarios de archivos.
* Crea un archivo llamado `privado.txt`:
* Cambia los permisos del archivo para que solo el propietario pueda leer y escribir:
* Cambia el propietario del archivo a otro usuario (si tienes privilegios):

```bash
vboxuser@uwuntu:~/Desktop$ touch privado.txt
vboxuser@uwuntu:~/Desktop$ chmod 600 privado.txt
vboxuser@uwuntu:~/Desktop$ sudo chown usuario privado.txt
[sudo] password for vboxuser: 
chown: invalid user: ‘usuario’
vboxuser@uwuntu:~/Desktop$ sudo chown other privado.txt
vboxuser@uwuntu:~/Desktop$ 
```

## Ejercicio 6: Exploración de Dispositivos

* Objetivo: Identificar discos y particiones en el sistema.
* Usa `lsblk` para listar los discos y particiones:
* Usa `du -sh` para ver el tamaño del contenido en un directorio de tu elección:
* Verifica el uso de disco con `df -h`:

```bash
vboxuser@uwuntu:~$ lsblk
NAME   MAJ:MIN RM   SIZE RO TYPE MOUNTPOINTS
loop0    7:0    0  74.3M  1 loop /snap/core22/1564
loop1    7:1    0     4K  1 loop /snap/bare/5
loop2    7:2    0  73.9M  1 loop /snap/core22/1722
loop3    7:3    0 269.8M  1 loop /snap/firefox/4793
loop4    7:4    0  10.7M  1 loop /snap/firmware-updater/127
loop5    7:5    0  11.1M  1 loop /snap/firmware-updater/147
loop6    7:6    0 505.1M  1 loop /snap/gnome-42-2204/176
loop7    7:7    0  91.7M  1 loop /snap/gtk-common-themes/1535
loop8    7:8    0  10.5M  1 loop /snap/snap-store/1173
loop9    7:9    0  38.8M  1 loop /snap/snapd/21759
loop10   7:10   0  44.3M  1 loop /snap/snapd/23258
loop11   7:11   0   500K  1 loop /snap/snapd-desktop-integration/178
loop12   7:12   0   568K  1 loop /snap/snapd-desktop-integration/253
sda      8:0    0    25G  0 disk 
├─sda1   8:1    0     1M  0 part 
└─sda2   8:2    0    25G  0 part /
sr0     11:0    1  56.9M  0 rom  /media/vboxuser/VBox_GAs_7.1.4
vboxuser@uwuntu:~$ du -sh /home/vboxuser/Desktop
12K	/home/vboxuser/Desktop
vboxuser@uwuntu:~$    df -h
Filesystem      Size  Used Avail Use% Mounted on
tmpfs           794M  1.5M  793M   1% /run
/dev/sda2        25G  5.8G   18G  26% /
tmpfs           3.9G     0  3.9G   0% /dev/shm
tmpfs           5.0M  8.0K  5.0M   1% /run/lock
tmpfs           794M  140K  794M   1% /run/user/1000
/dev/sr0         57M   57M     0 100% /media/vboxuser/VBox_GAs_7.1.4
vboxuser@uwuntu:~$ 
```

## Ejercicio 7: Crear y Formatear Particiones

* Objetivo: Crear y formatear una nueva partición (Usar disco de práctica o máquina virtual).
* Identifica un disco no particionado:
* Usa `fdisk` para crear una nueva partición:
* Formatea la partición como `ext4`:
* Monta la partición en un directorio y prueba escribiendo archivos en ella:

```bash
vboxuser@uwuntu:~$ lsblk
NAME   MAJ:MIN RM   SIZE RO TYPE MOUNTPOINTS
loop0    7:0    0  74.3M  1 loop /snap/core22/1564
loop1    7:1    0     4K  1 loop /snap/bare/5
loop2    7:2    0 269.8M  1 loop /snap/firefox/4793
loop3    7:3    0  73.9M  1 loop /snap/core22/1722
loop4    7:4    0  10.7M  1 loop /snap/firmware-updater/127
loop5    7:5    0  11.1M  1 loop /snap/firmware-updater/147
loop6    7:6    0 505.1M  1 loop /snap/gnome-42-2204/176
loop7    7:7    0  91.7M  1 loop /snap/gtk-common-themes/1535
loop8    7:8    0  10.5M  1 loop /snap/snap-store/1173
loop9    7:9    0  44.3M  1 loop /snap/snapd/23258
loop10   7:10   0  38.8M  1 loop /snap/snapd/21759
loop11   7:11   0   500K  1 loop /snap/snapd-desktop-integration/178
loop12   7:12   0   568K  1 loop /snap/snapd-desktop-integration/253
sda      8:0    0    25G  0 disk 
├─sda1   8:1    0     1M  0 part 
└─sda2   8:2    0    25G  0 part /
sdb      8:16   0  19.3M  0 disk 
sr0     11:0    1  56.9M  0 rom  /media/vboxuser/VBox_GAs_7.1.4
vboxuser@uwuntu:~$    sudo fdisk -l
[sudo] password for vboxuser: 
Disk /dev/loop0: 74.27 MiB, 77881344 bytes, 152112 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop1: 4 KiB, 4096 bytes, 8 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop2: 269.77 MiB, 282873856 bytes, 552488 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop3: 73.87 MiB, 77459456 bytes, 151288 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop4: 10.72 MiB, 11239424 bytes, 21952 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop5: 11.11 MiB, 11649024 bytes, 22752 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop6: 505.09 MiB, 529625088 bytes, 1034424 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop7: 91.69 MiB, 96141312 bytes, 187776 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/sda: 25 GiB, 26843545600 bytes, 52428800 sectors
Disk model: VBOX HARDDISK   
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disklabel type: gpt
Disk identifier: 74325FC8-8394-472E-B18F-11319C58F470

Device     Start      End  Sectors Size Type
/dev/sda1   2048     4095     2048   1M BIOS boot
/dev/sda2   4096 52426751 52422656  25G Linux filesystem


Disk /dev/sdb: 19.3 MiB, 20232704 bytes, 39517 sectors
Disk model: VBOX HARDDISK   
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop8: 10.54 MiB, 11051008 bytes, 21584 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop9: 44.3 MiB, 46448640 bytes, 90720 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop10: 38.83 MiB, 40714240 bytes, 79520 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop11: 500 KiB, 512000 bytes, 1000 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop12: 568 KiB, 581632 bytes, 1136 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
vboxuser@uwuntu:~$ ^C
vboxuser@uwuntu:~$ sudo fdisk /dev/sdb

Welcome to fdisk (util-linux 2.39.3).
Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.

Device does not contain a recognized partition table.
Created a new DOS (MBR) disklabel with disk identifier 0x1fbc2a73.

Command (m for help):  sudo mkfs.ext4 /dev/sdX1
Created a new partition 1 of type 'Linux native' and of size 7.8 MiB.
Created a new partition 2 of type 'Linux swap' and of size 7.8 MiB.
Created a new partition 3 of type 'Whole disk' and of size 15.7 MiB.
Created a new Sun disklabel.

vboxuser@uwuntu:~/Desktop$ sudo mkfs.ext4 /dev/sdb
[sudo] password for vboxuser: 
mke2fs 1.47.0 (5-Feb-2023)
Creating filesystem with 4939 4k blocks and 4944 inodes

Allocating group tables: done                            
Writing inode tables: done                            
Creating journal (1024 blocks): done
Writing superblocks and filesystem accounting information: done


```
