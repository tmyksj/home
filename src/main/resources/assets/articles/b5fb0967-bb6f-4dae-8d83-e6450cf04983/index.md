## refs

- [Sneak Peek: Taking a Spin with Enhanced Linux VMs](https://techcommunity.microsoft.com/t5/virtualization/sneak-peek-taking-a-spin-with-enhanced-linux-vms/ba-p/382415)
- [microsoft/linux-vm-tools](https://github.com/microsoft/linux-vm-tools)

## body

クイック作成から作成した vm は拡張セッションモードが有効になっています。ただ、クイック作成で作成しても拡張セッションモードが有効にならないときや、 ubuntu 日本語 remix
を使用するときには、手動で拡張セッションモードを有効化する必要があります。

1. guest os で [microsoft/linux-vm-tools](https://github.com/microsoft/linux-vm-tools) の `install.sh` を実行し、 `xrdp`
   をインストールします。

   ubuntu 18.04 は、 `ubuntu/18.04/install.sh` を使用します。

   ubuntu 20.04 は、 [#106](https://github.com/microsoft/linux-vm-tools/pull/106) の `ubuntu/20.04/install.sh` を使用します。

1. host os で `EnhancedSessionTransportType` を `HvSocket` に変更します。
   ```
   Set-VM -VMName {vmname} -EnhancedSessionTransportType HvSocket
   ```

これで、拡張セッションモードが有効になります。
