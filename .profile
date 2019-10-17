#!/bin/bash
mkdir /etc/ssl/certs/dpcert
ls -la /etc/ssl/certs | grep "dp"
echo | openssl s_client -showcerts -servername emvdata-dp3.intg.apptoapp.net -connect emvdata-dp3.intg.apptoapp.net:443 2>/dev/null | openssl x509 -inform pem -noout -text
openssl s_client -showcerts -connect emvdata-dp3.intg.apptoapp.net:443 </dev/null 2>/dev/null|openssl x509 -outform der >/etc/ssl/certs/dpcert/servercertfile.crt
echo "Creating truststore"
echo pwd
cd /usr
find . -name "update-ca-certificates"
./usr/sbin/update-ca-certificates
echo "Done with custom .profile "